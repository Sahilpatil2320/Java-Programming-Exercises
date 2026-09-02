import javax.swing.*;
import java.awt.event.*;

public class Subproblem4 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Boat Ticket System");
        frame.setSize(400, 300);
        frame.setLayout(null);

        JLabel l1 = new JLabel("Customer Name:");
        l1.setBounds(30, 30, 120, 30);
        JTextField tf1 = new JTextField();
        tf1.setBounds(150, 30, 180, 30);

        JLabel l2 = new JLabel("Passengers:");
        l2.setBounds(30, 70, 120, 30);
        JTextField tf2 = new JTextField();
        tf2.setBounds(150, 70, 180, 30);

        JLabel l3 = new JLabel("Ride Type:");
        l3.setBounds(30, 110, 120, 30);
        String[] rideTypes = {"Standard", "Luxury"};
        JComboBox<String> cb = new JComboBox<>(rideTypes);
        cb.setBounds(150, 110, 180, 30);

        JButton addBtn = new JButton("Add Ticket");
        addBtn.setBounds(50, 160, 120, 30);

        JButton viewBtn = new JButton("View Tickets");
        viewBtn.setBounds(200, 160, 130, 30);

        addBtn.addActionListener(e -> {
            try {
                String name = tf1.getText();
                int passengers = Integer.parseInt(tf2.getText());
                String type = (String) cb.getSelectedItem();

                TicketValidator.validatePassengers(passengers);

                FareCalculator ticket;
                if (type.equals("Standard")) {
                    ticket = new StandardRide(name, passengers);
                } else {
                    ticket = new LuxuryRide(name, passengers);
                }

                double fare = ticket.calculateFare();
                FileManager.saveTicket(new Ticket(name, passengers, fare));
                JOptionPane.showMessageDialog(frame, "Ticket saved! Total fare: ₹" + fare);

            } catch (InvalidPassengerException ex) {
                JOptionPane.showMessageDialog(frame, ex.getMessage());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Invalid Input!");
            }
        });

        viewBtn.addActionListener(e -> FileManager.readTickets());

        frame.add(l1); frame.add(tf1);
        frame.add(l2); frame.add(tf2);
        frame.add(l3); frame.add(cb);
        frame.add(addBtn); frame.add(viewBtn);

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
