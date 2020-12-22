package ToDo;

public class ToDo {

    public static void main(String[] args) {

        String firstNoteName = "First Note";
        String firstTask = "First Task";
        String secondTask = "2. Push ToDo";

        StickyNote firstNote = new StickyNote(firstNoteName);


        System.out.println("new: " + firstNote.toString());
        System.out.println(firstNote.title);

        System.out.println("addItem: " + firstNote.addItem(firstNote, firstTask));
        System.out.println("added: " + firstNote.toString());
        System.out.println("addItem: " + firstNote.addItem(firstNote, secondTask));
        System.out.println("added: " + firstNote.toString());




/*        try {
            File toDoFile = new File("todo.txt");
            if (toDoFile.createNewFile()) {
                System.out.println("File created: " + toDoFile.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        try {
            add("newTask");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void add(String newTask) throws IOException {
        List<String> content = new ArrayList();
        content.add(newTask);

        Path filePath = Paths.get("todo.txt");
        Files.write(filePath, content);

        return;
    }

    public static void read() throws IOException {
        Path filePath = Paths.get("todo.txt");
        List<String> lines = Files.readAllLines(filePath);
        System.out.println(lines.get(0));

        return; */

    }
}

