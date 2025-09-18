public abstract class Sortable {
  public abstract int compare(Sortable b);

  public static void shell_sort(Sortable[] a) {
    int n = a.length;
    int h = 1;

    while (h <= n / 3)
      h = h * 3 + 1;

    while (h > 0) {
      for (int i = h; i < n; ++i) {
        Sortable tmp = a[i];

        int j = i;

        while (j > h - 1 && a[j - h].compare(tmp) > 0) {
          a[j] = a[j - h];
          j -= h;
        }

        a[j] = tmp;
      }

      h = (h - 1) / 3;
    }
  }
}