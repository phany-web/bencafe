package login.java.form;

import java.awt.*;
import javax.swing.*; 

public class Menupage extends JFrame {

    public Menupage() {

        setTitle("Ben Cafe - Menu");
        setSize(1200,700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        //================ LEFT SIDEBAR ==================
        JPanel left = new JPanel();
        left.setPreferredSize(new Dimension(180, 800));
        left.setBackground(new Color(245, 237, 224));
        left.setLayout(new BorderLayout());

        // Top menu
        JPanel menuPanel = new JPanel();
        menuPanel.setBackground(new Color(245, 237, 224));
        menuPanel.setLayout(new GridLayout(7, 1, 5, 5));

        menuPanel.add(new JLabel("☕ Ben Cafe"));
        menuPanel.add(new JButton("Home"));
        menuPanel.add(new JButton("Orders"));

        menuPanel.setPreferredSize(new Dimension(150,500));


        // Bottom logout
        JButton logout = new JButton("Logout");
        JPanel bottomPanel = new JPanel(new FlowLayout());
        logout.setPreferredSize(new Dimension(150, 50));
        bottomPanel.setBackground(new Color(245, 237, 224));
        bottomPanel.add(logout);

        // Add to sidebar
        left.add(menuPanel, BorderLayout.NORTH);
        left.add(bottomPanel, BorderLayout.SOUTH);

        // Add sidebar to frame
        add(left, BorderLayout.WEST);

        //================ CENTER ==================
        JPanel center = new JPanel(new BorderLayout());

        JPanel top = new JPanel();

        JTextField search = new JTextField(25);
        JButton filter = new JButton("Filter");

        top.add(search);
        top.add(filter);

        center.add(top,BorderLayout.NORTH);

        JPanel products = new JPanel();

        // 5 Cards each row
        products.setLayout(new GridLayout(0,5,15,15));
        products.setBackground(new Color(250,240,230));
        products.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));

        products.add(createCard("image/cappuccino.jpg","Cappuccino","$1.50"));
        products.add(createCard("image/latte.jpg","Latte","$1.60"));
        products.add(createCard("image/americano.jpg","Americano","$1.55"));
        products.add(createCard("image/mocha.jpg","Mocha","$2.00"));
        products.add(createCard("image/espresso.jpg","Espresso","$1.20"));
            
        products.add(createCard("image/macchiato.jpg","Macchiato","$2.20"));
        products.add(createCard("image/flatwhite.jpg","Flat White","$2.10"));
        products.add(createCard("image/coldbrew.jpg","Cold Brew","$2.30"));
        products.add(createCard("image/affogato.jpg","Affogato","$2.50"));
        products.add(createCard("image/chocolate.jpg","Chocolate","$2.00"));
            
        products.add(createCard("image/greentea.jpg","Green Tea","$1.70"));
        products.add(createCard("image/milktea.jpg","Milk Tea","$1.90"));
        products.add(createCard("image/orangejuice.jpg","Orange Juice","$2.10"));
        products.add(createCard("image/smoothie.jpg","Smoothie","$2.80"));
        products.add(createCard("image/icecoffee.jpg","Ice Coffee","$2.00"));

        JScrollPane scroll = new JScrollPane(products);
        scroll.getVerticalScrollBar().setUnitIncrement(16);

        center.add(scroll,BorderLayout.CENTER);

        add(center,BorderLayout.CENTER);

        

        setVisible(true);
    }

private JPanel createCard(String imagePath, String name, String price) {

    JPanel card = new JPanel();
    card.setPreferredSize(new Dimension(180, 250));
    card.setBackground(Color.WHITE);
    card.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
    card.setLayout(new BorderLayout());

    // Coffee Image
    ImageIcon icon = new ImageIcon(imagePath);
//    Image img = icon.getImage().getScaledInstance(140, 120, Image.SCALE_SMOOTH);

//    JLabel image = new JLabel(new ImageIcon(img));
//    image.setHorizontalAlignment(SwingConstants.CENTER);

    // Information Panel
    JPanel info = new JPanel();
    info.setBackground(Color.WHITE);
    info.setLayout(new GridLayout(4,1));

    JLabel lblName = new JLabel(name, SwingConstants.CENTER);
    lblName.setFont(new Font("Segoe UI", Font.BOLD, 15));

    JLabel lblPrice = new JLabel(price, SwingConstants.CENTER);
    lblPrice.setForeground(new Color(111,78,55));

    JPanel size = new JPanel();
    size.setBackground(Color.WHITE);

    JButton small = new JButton("S");
    JButton large = new JButton("L");

    size.add(small);
    size.add(large);

    JPanel bottom = new JPanel();
    bottom.setBackground(Color.WHITE);

    JButton add = new JButton("Add to Cart");
    bottom.add(add);

    info.add(lblName);
    info.add(lblPrice);
    info.add(size);
    info.add(bottom);

//    card.add(image, BorderLayout.NORTH);
    card.add(info, BorderLayout.CENTER);

    return card;
    }
}