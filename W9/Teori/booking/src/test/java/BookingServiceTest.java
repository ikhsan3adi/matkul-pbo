import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import com.services.*;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("Test BookingService - Sistem Pemesanan Tiket Bioskop")
class BookingServiceTest {

    @Mock
    private MovieRepository movieRepo;

    @Mock
    private PaymentGateway paymentGateway;

    @InjectMocks
    private BookingService bookingService;

    private Movie sampleMovie;

    @BeforeEach
    void setUp() {
        sampleMovie = new Movie("Avengers", 10, 50000);
    }

    // ---  Test Skenario Positif ---
    @Test
    @DisplayName("  Sukses memesan tiket saat kursi cukup dan pembayaran berhasil")
    void testBookingSuccess() {
        when(movieRepo.findByTitle("Avengers")).thenReturn(sampleMovie);
        when(paymentGateway.processPayment("user123", 2 * 50000)).thenReturn(true);

        String result = bookingService.bookTicket("user123", "Avengers", 2);

        assertAll(
            () -> assertEquals("Booking successful", result),
            () -> verify(movieRepo, times(1)).findByTitle("Avengers"),
            () -> verify(paymentGateway, times(1)).processPayment("user123", 100000),
            () -> verify(movieRepo, times(1)).updateSeats("Avengers", 8)
        );
    }

    // ---   Test Kasus Film Tidak Ditemukan ---
    @Test
    @DisplayName("  Gagal memesan jika film tidak ditemukan")
    void testMovieNotFound() {
        when(movieRepo.findByTitle("Unknown")).thenReturn(null);

        Exception ex = assertThrows(IllegalArgumentException.class, () ->
            bookingService.bookTicket("user123", "Unknown", 2)
        );

        assertEquals("Movie not found", ex.getMessage());
        verify(movieRepo, times(1)).findByTitle("Unknown");
        verifyNoInteractions(paymentGateway);
    }

    // ---  ztest Kasus Kursi Tidak Cukup ---
    @Test
    @DisplayName("  Gagal memesan jika kursi tidak cukup")
    void testNotEnoughSeats() {
        sampleMovie.setAvailableSeats(1);
        when(movieRepo.findByTitle("Avengers")).thenReturn(sampleMovie);

        Exception ex = assertThrows(IllegalStateException.class, () ->
            bookingService.bookTicket("user123", "Avengers", 3)
        );

        assertEquals("Not enough seats available", ex.getMessage());
        verify(movieRepo, times(1)).findByTitle("Avengers");
        verifyNoInteractions(paymentGateway);
    }

    // ---   Test Kasus Pembayaran Gagal ---
    @Test
    @DisplayName("  Gagal memesan jika pembayaran gagal")
    void testPaymentFailed() {
        when(movieRepo.findByTitle("Avengers")).thenReturn(sampleMovie);
        when(paymentGateway.processPayment("user123", 100000)).thenReturn(false);

        String result = bookingService.bookTicket("user123", "Avengers", 2);

        assertEquals("Payment failed", result);
        verify(movieRepo, times(1)).findByTitle("Avengers");
        verify(paymentGateway, times(1)).processPayment("user123", 100000);
        verify(movieRepo, never()).updateSeats(anyString(), anyInt());
    }

    // ---   Test Verifikasi Interaksi Lengkap ---
    @Test
    @DisplayName("Verifikasi panggilan metode eksternal")
    void testVerifyInteractions() {
        when(movieRepo.findByTitle("Avengers")).thenReturn(sampleMovie);
        when(paymentGateway.processPayment("user123", 100000)).thenReturn(true);

        bookingService.bookTicket("user123", "Avengers", 2);

        InOrder inOrder = inOrder(movieRepo, paymentGateway);
        inOrder.verify(movieRepo).findByTitle("Avengers");
        inOrder.verify(paymentGateway).processPayment("user123", 100000);
        inOrder.verify(movieRepo).updateSeats("Avengers", 8);
    }
}