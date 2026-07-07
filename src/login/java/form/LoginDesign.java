package login.java.form;

import dbconnection.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class LoginDesign extends JFrame {

    JPanel p = new JPanel();

    LoginDesign() {

        this.setTitle("បេនកាហ្វេ- Ben Cafe");

        ImageIcon icon = new ImageIcon("image/BenCafeLogo.png");
        this.setIconImage(icon.getImage());

        this.setSize(1000, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        // Load and scale the background image
        ImageIcon backgroundIcon = new ImageIcon("image/Background.jpg");
        Image scaledImage = backgroundIcon.getImage().getScaledInstance(1000, 800, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        JLabel label = new JLabel(scaledIcon);
        label.setBounds(0, 0, 1000, 800);
        label.setLayout(null);

        // Login form
        JPanel loginForm = new JPanel();
        loginForm.setLayout(null);
        loginForm.setBackground(new Color(245, 237, 224));
        loginForm.setOpaque(true);
        loginForm.setBounds(300, 150, 380, 500);
        label.add(loginForm);

        // Logo
        ImageIcon logo = new ImageIcon("image/BenCafeLogo.png");
        Image logoImage = logo.getImage().getScaledInstance(200, 100, Image.SCALE_SMOOTH);
        JLabel lblLogo = new JLabel(new ImageIcon(logoImage));
        lblLogo.setBounds(150, 10, 80, 80);
        loginForm.add(lblLogo);

        // Cup icon
        ImageIcon Icon_cup = new ImageIcon("image/Cup.png");
        Image logoCupImage = Icon_cup.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        JLabel lblLogoCup = new JLabel(new ImageIcon(logoCupImage));
        lblLogoCup.setBounds(10, 95, 200, 30);
        loginForm.add(lblLogoCup);

        // Coffee bean icon
        ImageIcon CoffeBean = new ImageIcon("image/Icon_CoffeeBean.png");
        Image LogoCoffeBean = CoffeBean.getImage().getScaledInstance(25, 28, Image.SCALE_SMOOTH);
        JLabel LogoBean = new JLabel(new ImageIcon(LogoCoffeBean));
        LogoBean.setBounds(80, 160, 200, 30);
        loginForm.add(LogoBean);

        // Title
        JLabel lblTitle = new JLabel("Ben Cafe");
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 28));
        lblTitle.setForeground(new Color(102, 51, 0));
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitle.setBounds(90, 95, 200, 30);
        loginForm.add(lblTitle);

        JLabel lblTitle1 = new JLabel("Welcome Back");
        lblTitle1.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lblTitle1.setForeground(new Color(86, 46, 25));
        lblTitle1.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitle1.setBounds(90, 120, 200, 30);
        loginForm.add(lblTitle1);

        JLabel lblTitle2 = new JLabel("Please sign in to continue.");
        lblTitle2.setBounds(110, 140, 200, 30);
        lblTitle2.setForeground(new Color(111, 78, 55));
        loginForm.add(lblTitle2);

        JLabel lblTitle3 = new JLabel("© 2026 Ben Cafe | Version 1.0.0");
        lblTitle3.setBounds(90, 450, 220, 30);
        lblTitle3.setForeground(new Color(111, 78, 55));
        loginForm.add(lblTitle3);

        JLabel lblLine1 = new JLabel("__________");
        lblLine1.setBounds(80, 160, 200, 30);
        lblLine1.setForeground(new Color(111, 78, 55));
        loginForm.add(lblLine1);

        JLabel lblLine2 = new JLabel("__________");
        lblLine2.setBounds(210, 160, 200, 30);
        lblLine2.setForeground(new Color(111, 78, 55));
        loginForm.add(lblLine2);

        JLabel lblLine3 = new JLabel("________________________________");
        lblLine3.setBounds(80, 320, 210, 30);
        lblLine3.setForeground(new Color(111, 78, 55));
        loginForm.add(lblLine3);

        // Username label
        JLabel lblName = new JLabel("Username");
        lblName.setBounds(80, 190, 200, 30);
        lblName.setForeground(new Color(60, 40, 25));
        loginForm.add(lblName);

        // Username field
        ImageIcon userIcon = new ImageIcon("image/Icon_User.png");
        Image userImg = userIcon.getImage().getScaledInstance(18, 18, Image.SCALE_SMOOTH);

        IconTextField txtUser = new IconTextField(new ImageIcon(userImg), "Enter Username");
        txtUser.setBounds(80, 220, 200, 30);
        txtUser.setBackground(Color.WHITE);
        loginForm.add(txtUser);

        // Password label
        JLabel lblPass = new JLabel("Password");
        lblPass.setBounds(80, 245, 200, 30);
        lblPass.setForeground(new Color(60, 40, 25));
        loginForm.add(lblPass);

        // Password field
        ImageIcon lockIcon = new ImageIcon("image/Icon_lock.png");
        Image lockImg = lockIcon.getImage().getScaledInstance(18, 18, Image.SCALE_SMOOTH);

        IconPasswordField txtPass = new IconPasswordField(new ImageIcon(lockImg), "Enter Password");
        txtPass.setBounds(80, 270, 200, 30);
        txtPass.setBackground(Color.WHITE);
        loginForm.add(txtPass);

        // Eye icons
        ImageIcon openEye = new ImageIcon("image/Icon_Openeye.png");
        Image openImg = openEye.getImage().getScaledInstance(18, 18, Image.SCALE_SMOOTH);

        ImageIcon closeEye = new ImageIcon("image/Icon_Closeeye.png");
        Image closeImg = closeEye.getImage().getScaledInstance(18, 18, Image.SCALE_SMOOTH);

        // Eye button
        JButton eyeButton = new JButton(new ImageIcon(openImg));
        eyeButton.setBounds(275, 270, 30, 30);
        eyeButton.setFocusPainted(false);
        eyeButton.setBorderPainted(false);
        eyeButton.setContentAreaFilled(false);
        eyeButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        final boolean[] showing = {false};

        eyeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (showing[0]) {

                    txtPass.setEchoChar('*');
                    eyeButton.setIcon(new ImageIcon(openImg));
                    showing[0] = false;

                } else {

                    txtPass.setEchoChar((char) 0);
                    eyeButton.setIcon(new ImageIcon(closeImg));
                    showing[0] = true;
                }
            }
        });

        loginForm.add(eyeButton);

        // Remember checkbox
        JCheckBox chkRemember = new JCheckBox("Remember");
        chkRemember.setForeground(new Color(102, 51, 0));
        chkRemember.setBounds(80, 300, 100, 30);
        chkRemember.setFocusable(false);
        chkRemember.setBackground(new Color(245, 237, 224));
        loginForm.add(chkRemember);

        // Forgot password
        JLabel lblForgot = new JLabel("Forgot Password?");
        lblForgot.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        lblForgot.setForeground(Color.BLUE);
        lblForgot.setBounds(180, 300, 150, 30);
        lblForgot.setCursor(new Cursor(Cursor.HAND_CURSOR));
        loginForm.add(lblForgot);

        lblForgot.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JOptionPane.showMessageDialog(loginForm, "Password reset process...");
            }
        });

        // Login Button
        JButton buttonLogin = new JButton("Login");
        buttonLogin.setBounds(75, 370, 200, 40);
        buttonLogin.setFocusable(false);
        buttonLogin.setFont(new Font("Segoe UI", Font.BOLD, 20));
        buttonLogin.setBackground(new Color(111, 78, 55));
        buttonLogin.setForeground(Color.WHITE);
        buttonLogin.setCursor(new Cursor(Cursor.HAND_CURSOR));

        buttonLogin.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                String username = txtUser.getText().trim();
                String password = String.valueOf(txtPass.getPassword()).trim();

                if (username.isEmpty() || password.isEmpty()) {

                    JOptionPane.showMessageDialog(
                            loginForm,
                            "Please enter username and password!",
                            "Warning",
                            JOptionPane.WARNING_MESSAGE
                    );
                    return;
                }

                try {

                    Connection con = DBConnection.getConnection();

                    if (con == null) {
                        JOptionPane.showMessageDialog(
                                loginForm,
                                "Database connection failed!",
                                "Database Error",
                                JOptionPane.ERROR_MESSAGE
                        );
                        return;
                    }

                    String sql =
                            "SELECT u.userId, u.username, u.password, r.roleId, r.roleName " +
                            "FROM tbluser u " +
                            "INNER JOIN tblrole r ON u.roleId = r.roleId " +
                            "WHERE u.username = ? AND u.password = ?";

                    PreparedStatement ps = con.prepareStatement(sql);
                    ps.setString(1, username);
                    ps.setString(2, password);

                    ResultSet rs = ps.executeQuery();

                    if (rs.next()) {

                        int userId = rs.getInt("userId");
                        int roleId = rs.getInt("roleId");
                        String roleName = rs.getString("roleName");

                        JOptionPane.showMessageDialog(
                                loginForm,
                                "Login Successful!\nWelcome " + username,
                                "Success",
                                JOptionPane.INFORMATION_MESSAGE
                        );

                        System.out.println("User ID: " + userId);
                        System.out.println("Username: " + username);
                        System.out.println("Role ID: " + roleId);
                        System.out.println("Role Name: " + roleName);

                        dispose();

                        if (roleName.equalsIgnoreCase("admin")) {

                            JOptionPane.showMessageDialog(
                                    null,
                                    "Welcome Admin"
                            );

                            // Open Admin Dashboard here
                            // new AdminDashboard();
                            dispose();
                            new Menupage();

                        } else if (roleName.equalsIgnoreCase("staff")) {

                            JOptionPane.showMessageDialog(
                                    null,
                                    "Welcome Staff"
                            );

                            // Open Staff Dashboard here
                            // new StaffDashboard();
                            dispose();
                            new Menupage();
                        } else {

                            JOptionPane.showMessageDialog(
                                    null,
                                    "Unknown role: " + roleName
                            );
                        }

                    } else {

                        JOptionPane.showMessageDialog(
                                loginForm,
                                "Invalid username or password!",
                                "Login Failed",
                                JOptionPane.ERROR_MESSAGE
                        );
                    }

                    rs.close();
                    ps.close();
                    con.close();

                } catch (Exception ex) {

                    ex.printStackTrace();

                    JOptionPane.showMessageDialog(
                            loginForm,
                            "Database Error: " + ex.getMessage(),
                            "Error",
                            JOptionPane.ERROR_MESSAGE
                    );
                }
            }
        });

        loginForm.add(buttonLogin);

        // Main panel
        p.setLayout(null);
        p.setSize(1000, 800);
        p.add(label);

        this.add(p);

        // Make frame visible
        this.setVisible(true);
    }
}