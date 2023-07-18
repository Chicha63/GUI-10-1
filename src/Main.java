import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;

public class Main {
    static FileOper oper = new FileOper();
    public static void main(String[] args) {
        JFrame frame = new JFrame("Files");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JTextArea textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        JPanel panel1 = new JPanel();
        JButton button1 = new JButton("Exit");
        JButton button2 = new JButton("Select file");
        button2.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
            fileChooser.setFileFilter(filter);
            int val = fileChooser.showOpenDialog(frame);
            if (val == JFileChooser.APPROVE_OPTION){
                oper.setFile(fileChooser.getSelectedFile().getPath());
                textArea.setText(oper.readFile());
                frame.setTitle(fileChooser.getSelectedFile().getName());
            }
        });
        button1.addActionListener(e -> System.exit(0));
        panel1.add(button1);
        panel1.add(button2);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(panel1, BorderLayout.SOUTH);
        frame.setSize(400,400);
        frame.setVisible(true);
    }
}