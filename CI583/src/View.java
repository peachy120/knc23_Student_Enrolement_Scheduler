import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.*;
import java.util.Arrays;
import java.util.List;

public class View extends Thread {

    public void main(String[] arg) {

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

        JLabel msgLabel = new JLabel();
        msgLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        jPanel.add(msgLabel);

        JButton uploadButton = new JButton("Upload CSV");
        uploadButton.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileFilter(new FileNameExtensionFilter("CSV files", "csv"));

            int result = fileChooser.showOpenDialog(jFrame);
            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                fileLabel.setText("Selected: " + selectedFile.getName());

                File csvUploaded = selectedFile;
                String line;
                String delimiter = ",";

                try (BufferedReader bufferedReader = new BufferedReader(new FileReader(csvUploaded))) {
                    while ((line = bufferedReader.readLine()) != null) {
                        String[] value = line.split(delimiter);
                        //System.out.println(Arrays.toString(value));

                        Controller.addToWaitingQueue(value);
                    }
                } catch (IOException ee) {
                    msgLabel.setText("404 ERROR 404");

                    System.out.println("IO exception: " + ee.getMessage());
                } catch (Exception ee) {
                    msgLabel.setText("404 ERROR 404");

                    System.out.println("Error: " + ee.getMessage());
                }
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
        runButton.addActionListener(e -> {
            String selectedScheduling = jComboBox.getItemAt(jComboBox.getSelectedIndex());

            String schedulingMethod = "You selected " + selectedScheduling;

            System.out.println("You selected " + selectedScheduling);

            testingLabel.setText(schedulingMethod);

        });
        runButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        jPanel.add(runButton);

        jFrame.setVisible(true);
    }


}
