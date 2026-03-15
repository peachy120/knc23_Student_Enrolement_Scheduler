import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.nio.channels.FileChannel;

public class View {

    public static void main(String[] arg) {

        JFrame jFrame = new JFrame();
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(500,500);

        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.Y_AXIS));

        jFrame.add(jPanel);

        JLabel titleLabel = new JLabel("Student Enrolment System");
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        jPanel.add(titleLabel);

        JLabel uploadLabel = new JLabel("Upload a CSV file");
        uploadLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        jPanel.add(uploadLabel);

        JLabel fileLabel = new JLabel("No File Uploaded");
        fileLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        jPanel.add(fileLabel);

        JButton uploadButton = new JButton("Upload CSV");
        uploadButton.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("CSV files", "csv"));

            int result = fileChooser.showOpenDialog(jFrame);
            if (result == JFileChooser.APPROVE_OPTION) {
                java.io.File selectedFile = fileChooser.getSelectedFile();
                fileLabel.setText("Selected: " + selectedFile.getName());
            }
        });
        uploadButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        jPanel.add(uploadButton);

        JLabel schedulingLabel = new JLabel("Select a scheduling method to perform below");
        schedulingLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        jPanel.add(schedulingLabel);

        String[] schedulingOptions = {"Round Robin", "Priority Scheduling", "Multi-level Feedback Queue (MLFQ)"};
        final JComboBox<String> jComboBox = new JComboBox<>(schedulingOptions);
        jComboBox.setMaximumSize(jComboBox.getPreferredSize());
        jComboBox.setAlignmentX(Component.CENTER_ALIGNMENT);
        jPanel.add(jComboBox);

        JLabel testingLabel = new JLabel();
        testingLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        jPanel.add(testingLabel);

        JButton runButton = new JButton("RUN");
        runButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String selectedScheduling = jComboBox.getItemAt(jComboBox.getSelectedIndex());

                String schedulingMethod = "You selected " + selectedScheduling;

                System.out.println("You selected " + selectedScheduling);

                testingLabel.setText(schedulingMethod);
            }
        });
        runButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        jPanel.add(runButton);

        jFrame.setVisible(true);
    }


}
