package ToDo;

public class Settings {

    public static final String USAGE = "Parancssori Todo applikáció\n" +
            "=============================\n" +
            "\n" +
            "Parancssori argumentumok:\n" +
            "    -U           --- Kiírja USAGE-t\n" +
            "    -t name      --- Create StickyNoteFile\n" +
            "    -L           --- List StickyNoteFile\n" +
            "    -P name      --- Print name.txt\n" +
            "    -a add1...   --- Új feladatot ad hozzá\n" +
            "    -r           (Does not work!!) Eltávolít egy feladatot\n" +
            "    -c           (Does not work!!) Teljesít egy feladatot\n" +
            "    -e           --- Exit";

    public static final String USAGE_OPERATION = "-U";
    public static final String CREATE_STICKY_FILE_OPERATION = "-t";
    public static final String LIST_STICKY_FILES_OPERATION = "-L";
    public static final String PRINT_STICKY_NOTE_OPERATION = "-P";
    public static final String ADD_OPERATION = "-a";
    public static final String EXIT_OPERATION = "-e";

    public static final String STICKY_PATH = "Sticky/";


}
