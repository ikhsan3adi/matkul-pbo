# for linux \w wayland
javac -d bin src/id/ac/polban/poinoffsales/*.java && _JAVA_AWT_WM_NONREPARENTING=1 java -Dawt.toolkit=sun.awt.X11.XToolkit -cp bin id/ac/polban/poinoffsales/Main
