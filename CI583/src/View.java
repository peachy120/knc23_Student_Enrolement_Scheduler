import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
