package Duancanhan;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Calculator implements ActionListener {

    double number, answer;
    int calculation;

    JFrame frame; // Tao mot cua so chinh cho ung dung
    JLabel label = new JLabel(); // Tao mot nhan de hien thi ket qua hoac thong bao
    JTextField textField = new JTextField(); // Tao mot o van ban de nhap du lieu

// Tao hai nut radio de chon trang thai "on" hoac "off"
    JRadioButton onRadiobutton = new JRadioButton("on");
    JRadioButton offRadiobutton = new JRadioButton("off");

// Tao cac nut bam cho cac so tu 0 den 9 va cac chuc nang khac
    JButton buttonZero = new JButton("0");              // Nut bam cho so 0
    JButton buttonOne = new JButton("1");               // Nut bam cho so 1
    JButton buttonTwo = new JButton("2");               // Nut bam cho so 2
    JButton buttonThree = new JButton("3");             // Nut bam cho so 3
    JButton buttonFour = new JButton("4");              // Nut bam cho so 4
    JButton buttonFive = new JButton("5");              // Nut bam cho so 5
    JButton buttonSix = new JButton("6");               // Nut bam cho so 6
    JButton buttonSeven = new JButton("7");             // Nut bam cho so 7
    JButton buttonEight = new JButton("8");             // Nut bam cho so 8
    JButton buttonNine = new JButton("9");              // Nut bam cho so 9
    JButton buttonDot = new JButton(".");               // Nut bam cho dau cham (phan so)
    JButton buttonClear = new JButton("C");             // Nut bam de xoa toan bo
    JButton buttonDelete = new JButton("DEL");          // Nut bam de xoa ky tu cuoi cung
    JButton buttonEqual = new JButton("=");             // Nut bam de tinh toan ket qua
    JButton buttonMul = new JButton("x");               // Nut bam cho phep nhan
    JButton buttonDiv = new JButton("/");               // Nut bam cho phep chia
    JButton buttonPlus = new JButton("+");              // Nut bam cho phep cong
    JButton buttonMinus = new JButton("-");             // Nut bam cho phep tru
    JButton buttonSquare = new JButton("x²");           // Nut bam de tinh binh phuong
    JButton buttonReciprocal = new JButton("1/x");      // Nut bam de tinh nghich dao
    JButton buttonSqrt = new JButton("√");              // Nut bam de tinh can bac hai

    Calculator() {
        prepareGUI();
        addComponents();
        addActionEvent();
    }

    public void prepareGUI() {
        frame = new JFrame();                   // Tao mot cua so moi
        frame.setTitle("Casio");           // Dat tieu de cho cua so
        frame.setSize(290, 500);                // Tang kich thuoc cua cua so
        frame.getContentPane().setLayout(null); // Khong su dung layout manager, cho phep dat vi tri tuy y
        frame.setResizable(false);              // Khong cho phep thay doi kich thuoc cua cua so
        frame.setLocationRelativeTo(null);      // Dat vi tri cua so o giua man hinh
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Thoat ung dung khi dong cua so
        frame.setVisible(true);                 // Hien thi cua so
    }

    public void addComponents() {
        label.setBounds(250, 0, 50, 50); // Dat vi tri va kich thuoc cho nhan
        label.setForeground(Color.black); // Dat mau chu cho nhan
        frame.add(label); // Them nhan vao cua so

        textField.setBounds(10, 40, 270, 40); // Dat vi tri va kich thuoc cho o van ban
        textField.setFont(new Font("Arial", Font.BOLD, 20)); // Dat font cho o van ban
        textField.setEditable(false); // Khong cho phep chinh sua o van ban
        textField.setHorizontalAlignment(SwingConstants.RIGHT); // Canh phai noi dung trong o van ban
        frame.add(textField); // Them o van ban vao cua so

        onRadiobutton.setBounds(10, 95, 60, 40); // Dat vi tri va kich thuoc cho nut radio "on"
        onRadiobutton.setSelected(true); // Dat nut radio "on" la nut duoc chon
        onRadiobutton.setFont(new Font("Arial", Font.BOLD, 14)); // Dat font cho nut radio
        onRadiobutton.setForeground(Color.black); // Dat mau chu cho nut radio
        frame.add(onRadiobutton); // Them nut radio "on" vao cua so

        offRadiobutton.setBounds(10, 120, 60, 40); // Dat vi tri va kich thuoc cho nut radio "off"
        offRadiobutton.setFont(new Font("Arial", Font.BOLD, 14)); // Dat font cho nut radio
        offRadiobutton.setForeground(Color.black); // Dat mau chu cho nut radio
        frame.add(offRadiobutton); // Them nut radio "off" vao cua so

        ButtonGroup buttonGroup = new ButtonGroup(); // Tao nhom cho cac nut radio
        buttonGroup.add(onRadiobutton); // Them nut radio "on" vao nhom
        buttonGroup.add(offRadiobutton); // Them nut radio "off" vao nhom

        // Dat vi tri va kich thuoc cho cac nut so tu 7 den 0
        buttonSeven.setBounds(10, 230, 60, 40);
        buttonSeven.setFont(new Font("Arial", Font.BOLD, 20)); // Dat font cho nut
        frame.add(buttonSeven); // Them nut 7 vao cua so

        buttonEight.setBounds(80, 230, 60, 40);
        buttonEight.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(buttonEight); // Them nut 8 vao cua so

        buttonNine.setBounds(150, 230, 60, 40);
        buttonNine.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(buttonNine); // Them nut 9 vao cua so

        buttonFour.setBounds(10, 290, 60, 40);
        buttonFour.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(buttonFour); // Them nut 4 vao cua so

        buttonFive.setBounds(80, 290, 60, 40);
        buttonFive.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(buttonFive); // Them nut 5 vao cua so

        buttonSix.setBounds(150, 290, 60, 40);
        buttonSix.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(buttonSix); // Them nut 6 vao cua so

        buttonOne.setBounds(10, 350, 60, 40);
        buttonOne.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(buttonOne); // Them nut 1 vao cua so

        buttonTwo.setBounds(80, 350, 60, 40);
        buttonTwo.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(buttonTwo); // Them nut 2 vao cua so

        buttonThree.setBounds(150, 350, 60, 40);
        buttonThree.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(buttonThree); // Them nut 3 vao cua so

        buttonDot.setBounds(150, 410, 60, 40);
        buttonDot.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(buttonDot); // Them nut cham vao cua so

        buttonZero.setBounds(10, 410, 130, 40);
        buttonZero.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(buttonZero); // Them nut 0 vao cua so

        buttonEqual.setBounds(220, 350, 60, 100);
        buttonEqual.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(buttonEqual); // Them nut "=" vao cua so

        buttonDiv.setBounds(220, 110, 60, 40);
        buttonDiv.setBackground(new Color(239, 188, 2));
        frame.add(buttonDiv); // Them nut chia vao cua so

        buttonSqrt.setBounds(10, 170, 60, 40);
        buttonSqrt.setFont(new Font("Arial", Font.BOLD, 18));
        frame.add(buttonSqrt); // Them nut can bac hai vao cua so

        buttonMul.setBounds(220, 230, 60, 40);
        buttonMul.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(buttonMul); // Them nut nhan vao cua so

        buttonMinus.setBounds(220, 170, 60, 40);
        buttonMinus.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(buttonMinus); // Them nut tru vao cua so

        buttonPlus.setBounds(220, 290, 60, 40);
        buttonPlus.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(buttonPlus); // Them nut cong vao cua so

        buttonSquare.setBounds(80, 170, 60, 40);
        buttonSquare.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(buttonSquare); // Them nut binh phuong vao cua so

        buttonReciprocal.setBounds(150, 170, 60, 40);
        buttonReciprocal.setFont(new Font("Arial", Font.BOLD, 15));
        frame.add(buttonReciprocal); // Them nut nghich dao vao cua so

        buttonDelete.setBounds(150, 110, 60, 40);
        buttonDelete.setFont(new Font("Arial", Font.BOLD, 12));
        buttonDelete.setForeground(Color.black);
        frame.add(buttonDelete); // Them nut xoa vao cua so

        buttonClear.setFont(new Font("Arial", Font.BOLD, 12));
        buttonClear.setBounds(80, 110, 60, 40);
        buttonClear.setForeground(Color.black);
        frame.add(buttonClear); // Them nut xoa tat ca vao cua so
    }

    public void addActionEvent() {
        onRadiobutton.addActionListener(this);      // Them su kien cho nut radio "on"
        offRadiobutton.addActionListener(this);     // Them su kien cho nut radio "off"
        buttonClear.addActionListener(this);        // Them su kien cho nut xoa tat ca
        buttonDelete.addActionListener(this);       // Them su kien cho nut xoa ky tu cuoi
        buttonDiv.addActionListener(this);          // Them su kien cho nut chia
        buttonSqrt.addActionListener(this);         // Them su kien cho nut can bac hai
        buttonSquare.addActionListener(this);       // Them su kien cho nut binh phuong
        buttonReciprocal.addActionListener(this);   // Them su kien cho nut nghich dao
        buttonMinus.addActionListener(this);        // Them su kien cho nut tru
        buttonSeven.addActionListener(this);        // Them su kien cho nut 7
        buttonEight.addActionListener(this);        // Them su kien cho nut 8
        buttonNine.addActionListener(this);         // Them su kien cho nut 9
        buttonMul.addActionListener(this);          // Them su kien cho nut nhan
        buttonFour.addActionListener(this);         // Them su kien cho nut 4
        buttonFive.addActionListener(this);         // Them su kien cho nut 5
        buttonSix.addActionListener(this);          // Them su kien cho nut 6
        buttonPlus.addActionListener(this);         // Them su kien cho nut cong
        buttonOne.addActionListener(this);          // Them su kien cho nut 1
        buttonTwo.addActionListener(this);          // Them su kien cho nut 2
        buttonThree.addActionListener(this);        // Them su kien cho nut 3
        buttonEqual.addActionListener(this);        // Them su kien cho nut "="
        buttonZero.addActionListener(this);         // Them su kien cho nut 0
        buttonDot.addActionListener(this);          // Them su kien cho nut cham
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();          // Lay nguon cua su kien

        if (source == onRadiobutton) {          // Neu nut radio "on" duoc nhan
            enable();                           // Kich hoat chuc nang
        } else if (source == offRadiobutton) {  // Neu nut radio "off" duoc nhan
            disable();                          // Vo hieu hoa chuc nang
        } else if (source == buttonClear) {     // Neu nut xoa tat ca duoc nhan
            label.setText("");                  // Xoa noi dung nhan
            textField.setText("");              // Xoa noi dung o van ban
        } else if (source == buttonDelete) {    // Neu nut xoa ky tu cuoi cung duoc nhan
            int length = textField.getText().length(); // Lay do dai cua noi dung o van ban
            int number = length - 1;            // Tinh chi so ky tu cuoi cung
            if (length > 0) {                   // Neu o van ban khong rong
                StringBuilder back = new StringBuilder(textField.getText()); // Tao mot StringBuilder tu noi dung o van ban
                back.deleteCharAt(number);      // Xoa ky tu cuoi cung
                textField.setText(back.toString()); // Cap nhat noi dung o van ban
            }
            if (textField.getText().endsWith("")) { // Neu o van ban rong
                label.setText("");              // Xoa noi dung nhan
            }
        } else if (source == buttonZero) {      // Neu nut 0 duoc nhan
            if (textField.getText().equals("0")) { // Neu o van ban da co "0"
                return;                         // Khong lam gi
            } else {
                textField.setText(textField.getText() + "0"); // Them "0" vao o van ban
            }
        } else if (source == buttonOne) {
            textField.setText(textField.getText() + "1"); // Them "1" vao o van ban
        } else if (source == buttonTwo) {
            textField.setText(textField.getText() + "2"); // Them "2" vao o van ban
        } else if (source == buttonThree) {
            textField.setText(textField.getText() + "3"); // Them "3" vao o van ban
        } else if (source == buttonFour) {
            textField.setText(textField.getText() + "4"); // Them "4" vao o van ban
        } else if (source == buttonFive) {
            textField.setText(textField.getText() + "5"); // Them "5" vao o van ban
        } else if (source == buttonSix) {
            textField.setText(textField.getText() + "6"); // Them "6" vao o van ban
        } else if (source == buttonSeven) {
            textField.setText(textField.getText() + "7"); // Them "7" vao o van ban
        } else if (source == buttonEight) {
            textField.setText(textField.getText() + "8"); // Them "8" vao o van ban
        } else if (source == buttonNine) {
            textField.setText(textField.getText() + "9"); // Them "9" vao o van ban
        } else if (source == buttonDot) {
            if (textField.getText().contains(".")) { // Neu o van ban da co cham
                return;
            } else {
                textField.setText(textField.getText() + "."); // Them cham vao o van ban
            }
        } else if (source == buttonPlus) {              // Neu nut cong duoc nhan
            String str = textField.getText();           // Luu noi dung o van ban
            number = Double.parseDouble(textField.getText()); // Chuyen doi noi dung o van ban thanh so
            textField.setText("");                      // Xoa o van ban
            label.setText(str + "+");                   // Cap nhat nhan
            calculation = 1;                            // Luu tru loai phep toan la phep cong
        } else if (source == buttonMinus) {             // Neu nut tru duoc nhan
            String str = textField.getText();           // Luu noi dung o van ban
            number = Double.parseDouble(textField.getText()); // Chuyen doi noi dung o van ban thanh so
            textField.setText("");                      // Xoa o van ban
            label.setText(str + "-");                   // Cap nhat nhan
            calculation = 2;                            // Luu tru loai phep toan la phep tru
        } else if (source == buttonMul) {               // Neu nut nhan duoc nhan
            String str = textField.getText();           // Luu noi dung o van ban
            number = Double.parseDouble(textField.getText()); // Chuyen doi noi dung o van ban thanh so
            textField.setText("");                      // Xoa o van ban
            label.setText(str + "X");                   // Cap nhat nhan
            calculation = 3;                            // Luu tru loai phep toan la phep nhan
        } else if (source == buttonDiv) {               // Neu nut chia duoc nhan
            String str = textField.getText();           // Luu noi dung o van ban
            number = Double.parseDouble(textField.getText()); // Chuyen doi noi dung o van ban thanh so
            textField.setText("");                      // Xoa o van ban
            label.setText(str + "/");                   // Cap nhat nhan
            calculation = 4;                            // Luu tru loai phep toan la phep chia
        } else if (source == buttonSqrt) {              // Neu nut can bac hai duoc nhan
            try {
                number = Double.parseDouble(textField.getText()); // Chuyen doi noi dung o van ban thanh so
                if (number < 0) {                       // Neu so nho hon 0
                    textField.setText("Error: Negative number"); // Hien thi thong bao loi
                } else {
                    Double sqrt = Math.sqrt(number);    // Tinh can bac hai
                    textField.setText(Double.toString(sqrt)); // Hien thi ket qua
                }
            } catch (NumberFormatException ex) {        // Neu co loi khi chuyen doi
                textField.setText("Type number first!"); // Hien thi thong bao
            }
        } else if (source == buttonSquare) {            // Neu nut binh phuong duoc nhan
            String str = textField.getText();           // Luu noi dung o van ban
            number = Double.parseDouble(textField.getText()); // Chuyen doi noi dung o van ban thanh so
            double square = Math.pow(number, 2);        // Tinh binh phuong
            String string = Double.toString(square);    // Chuyen doi ket qua thanh chuoi
            if (string.endsWith(".0")) {                // Neu ket qua ket thuc bang ".0"
                textField.setText(string.replace(".0", "")); // Xoa ".0" trong ket qua
            } else {
                textField.setText(string);              // Hien thi ket qua
            }
            label.setText("sqr" + str);                 // Cap nhat nhan
        } else if (source == buttonReciprocal) {        // Neu nut nghich dao duoc nhan
            number = Double.parseDouble(textField.getText()); // Chuyen doi noi dung o van ban thanh so
            double reciprocal = 1 / number;             // Tinh nghich dao
            String string = Double.toString(reciprocal); // Chuyen doi ket qua thanh chuoi
            if (string.endsWith(".0")) {                // Neu ket qua ket thuc bang ".0"
                textField.setText(string.replace(".0", "")); // Xoa ".0" trong ket qua
            } else {
                textField.setText(string);              // Hien thi ket qua
            }
        } else if (source == buttonEqual) {             // Neu nut bang duoc nhan
            switch (calculation) {                      // Kiem tra loai phep toan
                case 1:                                 // Phep cong
                    answer = number + Double.parseDouble(textField.getText()); // Tinh tong
                    if (Double.toString(answer).endsWith(".0")) { // Neu ket qua ket thuc bang ".0"
                        textField.setText(Double.toString(answer).replace(".0", "")); // Xoa ".0" trong ket qua
                    } else {
                        textField.setText(Double.toString(answer)); // Hien thi ket qua
                    }
                    break;
                case 2:                                 // Phep tru
                    answer = number - Double.parseDouble(textField.getText()); // Tinh hieu
                    if (Double.toString(answer).endsWith(".0")) { // Neu ket qua ket thuc bang ".0"
                        textField.setText(Double.toString(answer).replace(".0", "")); // Xoa ".0" trong ket qua
                    } else {
                        textField.setText(Double.toString(answer)); // Hien thi ket qua
                    }
                    label.setText("");                  // Xoa noi dung nhan
                    break;
                case 3:                                 // Phep nhan
                    answer = number * Double.parseDouble(textField.getText()); // Tinh tich
                    if (Double.toString(answer).endsWith(".0")) { // Neu ket qua ket thuc bang ".0"
                        textField.setText(Double.toString(answer).replace(".0", "")); // Xoa ".0" trong ket qua
                    } else {
                        textField.setText(Double.toString(answer)); // Hien thi ket qua
                    }
                    label.setText("");                  // Xoa noi dung nhan
                    break;
                case 4:                                 // Phep chia
                    answer = number / Double.parseDouble(textField.getText()); // Tinh thuong
                    if (Double.toString(answer).endsWith(".0")) { // Neu ket qua ket thuc bang ".0"
                        textField.setText(Double.toString(answer).replace(".0", "")); // Xoa ".0" trong ket qua
                    } else {
                        textField.setText(Double.toString(answer)); // Hien thi ket qua
                    }
                    label.setText("");                  // Xoa noi dung nhan
                    break;
            }
        }
    }

    public void enable() {
        onRadiobutton.setEnabled(false); // Vo hieu hoa nut radio "on"
        offRadiobutton.setEnabled(true); // Kich hoat nut radio "off"
        textField.setEnabled(true); // Kich hoat o van ban
        label.setEnabled(true); // Kich hoat nhan
        buttonClear.setEnabled(true); // Kich hoat nut xoa tat ca
        buttonDelete.setEnabled(true); // Kich hoat nut xoa ky tu cuoi
        buttonDiv.setEnabled(true); // Kich hoat nut chia
        buttonSqrt.setEnabled(true); // Kich hoat nut can bac hai
        buttonSquare.setEnabled(true); // Kich hoat nut binh phuong
        buttonReciprocal.setEnabled(true); // Kich hoat nut nghich dao
        buttonMinus.setEnabled(true); // Kich hoat nut tru
        buttonSeven.setEnabled(true); // Kich hoat nut 7
        buttonEight.setEnabled(true); // Kich hoat nut 8
        buttonNine.setEnabled(true); // Kich hoat nut 9
        buttonMul.setEnabled(true); // Kich hoat nut nhan
        buttonFour.setEnabled(true); // Kich hoat nut 4
        buttonFive.setEnabled(true); // Kich hoat nut 5
        buttonSix.setEnabled(true); // Kich hoat nut 6
        buttonPlus.setEnabled(true); // Kich hoat nut cong
        buttonOne.setEnabled(true); // Kich hoat nut 1
        buttonTwo.setEnabled(true); // Kich hoat nut 2
        buttonThree.setEnabled(true); // Kich hoat nut 3
        buttonEqual.setEnabled(true); // Kich hoat nut "="
        buttonZero.setEnabled(true); // Kich hoat nut 0
        buttonDot.setEnabled(true); // Kich hoat nut cham
    }

    public void disable() {
        onRadiobutton.setEnabled(true); // Kich hoat nut radio "on"
        offRadiobutton.setEnabled(false); // Vo hieu hoa nut radio "off"
        textField.setText(""); // Xoa noi dung o van ban
        label.setText(" "); // Xoa noi dung nhan
        buttonClear.setEnabled(false); // Vo hieu hoa nut xoa tat ca
        buttonDelete.setEnabled(false); // Vo hieu hoa nut xoa ky tu cuoi
        buttonDiv.setEnabled(false); // Vo hieu hoa nut chia
        buttonSqrt.setEnabled(false); // Vo hieu hoa nut can bac hai
        buttonSquare.setEnabled(false); // Vo hieu hoa nut binh phuong
        buttonReciprocal.setEnabled(false); // Vo hieu hoa nut nghich dao
        buttonMinus.setEnabled(false); // Vo hieu hoa nut tru
        buttonSeven.setEnabled(false); // Vo hieu hoa nut 7
        buttonEight.setEnabled(false); // Vo hieu hoa nut 8
        buttonNine.setEnabled(false); // Vo hieu hoa nut 9
        buttonMul.setEnabled(false); // Vo hieu hoa nut nhan
        buttonFour.setEnabled(false); // Vo hieu hoa nut 4
        buttonFive.setEnabled(false); // Vo hieu hoa nut 5
        buttonSix.setEnabled(false); // Vo hieu hoa nut 6
        buttonPlus.setEnabled(false); // Vo hieu hoa nut cong
        buttonOne.setEnabled(false); // Vo hieu hoa nut 1
        buttonTwo.setEnabled(false); // Vo hieu hoa nut 2
        buttonThree.setEnabled(false); // Vo hieu hoa nut 3
        buttonEqual.setEnabled(false); // Vo hieu hoa nut "="
        buttonZero.setEnabled(false); // Vo hieu hoa nut 0
        buttonDot.setEnabled(false); // Vo hieu hoa nut cham
    }
}
