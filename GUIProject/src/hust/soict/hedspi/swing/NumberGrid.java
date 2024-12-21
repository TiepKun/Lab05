package hust.soict.hedspi.swing; 
 
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
public class NumberGrid extends JFrame {
    private JButton[] btnNumbers; // Mảng chứa các nút số
    private JButton btnDelete;   // Nút xóa số cuối
    private JButton btnReset;    // Nút xóa toàn bộ
    private JTextField tfDisplay; // Hiển thị số
 
    public NumberGrid() {
        // Cài đặt bố cục JFrame
        setTitle("Number Grid");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        // Cài đặt vùng hiển thị số
        tfDisplay = new JTextField();
        tfDisplay.setEditable(false); // Chỉ đọc
        tfDisplay.setHorizontalAlignment(JTextField.RIGHT);
        add(tfDisplay, BorderLayout.NORTH);
 
        // Cài đặt các nút trong JPanel
        JPanel panelButtons = new JPanel();
        panelButtons.setLayout(new GridLayout(4, 3, 5, 5)); // 4 hàng, 3 cột
        addButtons(panelButtons);
 
        // Thêm panelButtons vào JFrame
        add(panelButtons, BorderLayout.CENTER);
 
        // Hiển thị cửa sổ
        setVisible(true);
    }
 
    // Phương thức thêm nút vào panel
    private void addButtons(JPanel panelButtons) {
        // Khởi tạo mảng nút số
        btnNumbers = new JButton[10];
        for (int i = 1; i <= 9; i++) {
            btnNumbers[i] = new JButton(i + "");
            panelButtons.add(btnNumbers[i]);
            btnNumbers[i].addActionListener(new ButtonListener());
        }
 
        // Thêm nút Reset
        btnReset = new JButton("C");
        panelButtons.add(btnReset);
        btnReset.addActionListener(new ButtonListener());
 
        // Thêm nút số 0
        btnNumbers[0] = new JButton("0");
        panelButtons.add(btnNumbers[0]);
        btnNumbers[0].addActionListener(new ButtonListener());
 
        // Thêm nút Delete
        btnDelete = new JButton("DEL");
        panelButtons.add(btnDelete);
        btnDelete.addActionListener(new ButtonListener());
    }
 
    // Lớp xử lý sự kiện nút bấm
    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            if (command.equals("C")) {
                tfDisplay.setText(""); // Xóa toàn bộ
            } else if (command.equals("DEL")) {
                String currentText = tfDisplay.getText();
                if (currentText.length() > 0) {
                    tfDisplay.setText(currentText.substring(0, currentText.length() - 1)); // Xóa ký tự cuối
                }
            } else {
                tfDisplay.setText(tfDisplay.getText() + command); // Thêm số
            }
        }
    }
 
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new NumberGrid());
    }
}