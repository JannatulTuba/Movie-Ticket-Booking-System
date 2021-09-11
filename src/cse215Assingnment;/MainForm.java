import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.Toolkit;
import java.awt.Font;

public class MainForm extends JFrame implements ActionListener{
    mvTicketBooking m =new mvTicketBooking();

    private JFrame mvTicketBooking;

    private JTextField txtSeat;
    private JTextField lblNumOfSeats;
    private JTextField lblNumOfReservedSeats;
    private JTextField lblNumOfVacantSeats;
    private JTextField totalRev;
    private final ButtonGroup buttonGroup = new ButtonGroup();
    private JPanel contentPane;
    private JTextArea txtName;
    private JTextArea txtPrice;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MainForm window = new MainForm();
                    window.mvTicketBooking.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public MainForm() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        mvTicketBooking = new JFrame();
        mvTicketBooking.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\5000 Series\\Desktop\\Agnes-Overjoyed-icon (1).png"));
        mvTicketBooking.setTitle("Movie Ticket Booking System");
        mvTicketBooking.setBounds(100, 100, 872, 523);
        mvTicketBooking.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mvTicketBooking.getContentPane().setLayout(null);

        contentPane = new JPanel();
        contentPane.setBounds(13, 36, 833, 437);
        mvTicketBooking.getContentPane().add(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 262, 207);
        contentPane.add(panel);
        panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Booking Input", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 128)));
        panel.setLayout(null);

        JRadioButton rbtnReserve = new JRadioButton("Reserve");
        rbtnReserve.setFont(new Font("Tahoma", Font.BOLD, 12));
        buttonGroup.add(rbtnReserve);
        rbtnReserve.setBounds(6, 16, 109, 23);
        panel.add(rbtnReserve);

        JRadioButton rbtnCancel = new JRadioButton("Cancel");
        rbtnCancel.setFont(new Font("Tahoma", Font.BOLD, 12));
        buttonGroup.add(rbtnCancel);
        rbtnCancel.setBounds(147, 16, 109, 23);
        panel.add(rbtnCancel);

        txtSeat = new JTextField();
        txtSeat.setBounds(157, 102, 86, 20);
        panel.add(txtSeat);
        txtSeat.setColumns(10);

        JLabel lblNewLabel = new JLabel("Name");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblNewLabel.setBounds(22, 64, 46, 14);
        panel.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Seat No.");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblNewLabel_1.setBounds(22, 105, 46, 14);
        panel.add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("Price");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblNewLabel_2.setBounds(22, 153, 46, 14);
        panel.add(lblNewLabel_2);

        JButton btnOK = new JButton("Reserve/Cancel");
        btnOK.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if((e.getSource() == btnOK) && rbtnReserve.isSelected()){
                    String n = txtName.getText();
                    String p = txtPrice.getText();
                    m.nameAndPriceWrite(n,p);
                }
                if((e.getSource() == btnOK) && rbtnCancel.isSelected()){
                    int s = Integer.parseInt(txtSeat.getText());
                    m.delete(s);
                }
            }
        });

        contentPane.setLayout(null);

        btnOK.setBounds(49, 173, 138, 23);
        panel.add(btnOK);

        txtName = new JTextArea();
        txtName.setAlignmentY(0.0f);
        txtName.setBounds(157, 59, 86, 21);
        panel.add(txtName);

        txtPrice = new JTextArea();
        txtPrice.setAlignmentY(0.0f);
        txtPrice.setBounds(157, 148, 86, 21);
        panel.add(txtPrice);

        JPanel panel_1 = new JPanel();
        panel_1.setBounds(0, 236, 262, 197);
        contentPane.add(panel_1);
        panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Booking Output", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 128)));
        panel_1.setLayout(null);

        lblNumOfSeats = new JTextField(String.valueOf(m.getTotalSeat()));
        lblNumOfSeats.setBounds(141, 16, 86, 20);
        panel_1.add(lblNumOfSeats);
        lblNumOfSeats.setColumns(10);

        lblNumOfReservedSeats = new JTextField(String.valueOf(m.user));
        lblNumOfReservedSeats.setBounds(141, 66, 86, 20);
        panel_1.add(lblNumOfReservedSeats);
        lblNumOfReservedSeats.setColumns(10);

        lblNumOfVacantSeats = new JTextField(String.valueOf(m.numberOfVacant()));
        lblNumOfVacantSeats.setBounds(141, 120, 86, 20);
        panel_1.add(lblNumOfVacantSeats);
        lblNumOfVacantSeats.setColumns(10);

        totalRev = new JTextField(String.valueOf(m.totalRevenue()));
        totalRev.setBounds(141, 170, 86, 20);
        panel_1.add(totalRev);
        totalRev.setColumns(10);

        JLabel lblNewLabel_3 = new JLabel(" Number of Seats");
        lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblNewLabel_3.setBounds(6, 19, 109, 14);
        panel_1.add(lblNewLabel_3);

        JLabel lblNewLabel_4 = new JLabel("Number of Reserved");
        lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblNewLabel_4.setBounds(6, 69, 86, 14);
        panel_1.add(lblNewLabel_4);

        JLabel lblNewLabel_5 = new JLabel("Number of Vacant");
        lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblNewLabel_5.setBounds(6, 123, 109, 14);
        panel_1.add(lblNewLabel_5);

        JLabel lblNewLabel_6 = new JLabel("Total Revenue");
        lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblNewLabel_6.setBounds(6, 173, 86, 14);
        panel_1.add(lblNewLabel_6);

        JPanel panel_2 = new JPanel();
        panel_2.setBounds(272, 4, 561, 429);
        contentPane.add(panel_2);
        panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Reservations", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 128)));
        panel_2.setLayout(null);

        String[] string= new String[250];
        for (int i = 0; i < m.user; i++)
        {
            string[i]=("         " + (i+1) + "                    " + "Reserved\t              " + m.aName[i] + "\t                                      " + m.aPrice[i]);
        }

        JList list_1 = new JList(string);

        list_1.setBounds(21, 57, 530, 365);
        panel_2.add(list_1);

        JLabel lblNewLabel_7 = new JLabel("Seats");
        lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblNewLabel_7.setBounds(53, 16, 46, 14);
        panel_2.add(lblNewLabel_7);

        JLabel lblNewLabel_8 = new JLabel("Name");
        lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblNewLabel_8.setBounds(149, 16, 46, 14);
        panel_2.add(lblNewLabel_8);

        JLabel lblNewLabel_9 = new JLabel("Status");
        lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblNewLabel_9.setBounds(244, 16, 46, 14);
        panel_2.add(lblNewLabel_9);

        JLabel lblNewLabel_10 = new JLabel("Price");
        lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblNewLabel_10.setBounds(441, 16, 46, 14);
        panel_2.add(lblNewLabel_10);

    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        // TODO Auto-generated method stub

    }
}