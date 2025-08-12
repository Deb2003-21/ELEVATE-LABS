import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Jframe_todo {

    public static void main(String[] args) {

        DefaultListModel<String> model = new DefaultListModel<>();
        JList<String> todoList = new JList<>(model);

        // Create the main frame
        JFrame frame = new JFrame();
        frame.setSize(400, 400);
        frame.setLayout(new FlowLayout());
        JTextField textField = new JTextField(20);

        // create buttons
        JButton add = new JButton("Add");
        JButton remove = new JButton("Remove");

        // Create a scroll pane for the todo list
        JScrollPane scrollPane = new JScrollPane(todoList);
        scrollPane.setPreferredSize(new Dimension(300, 200));

        // Add action listeners for buttons
        add.addActionListener(e -> {

            String text = textField.getText();
            if (!text.isEmpty()) {
                model.addElement(" Task: " + text);
                textField.setText("");
            }
        });
        // Remove button action
        remove.addActionListener(e -> {
            int selectedIndex = todoList.getSelectedIndex();
            if (selectedIndex != -1) {
                model.remove(selectedIndex);
            }
        });

        // Frame settings
        frame.setTitle("JFrame Todo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.add(textField);
        frame.add(add);
        frame.add(remove);
        frame.add(scrollPane);

    }

}
