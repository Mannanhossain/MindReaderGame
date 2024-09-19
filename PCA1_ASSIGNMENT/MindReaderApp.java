import java.awt.*;
import java.awt.event.*;

public class MindReaderApp extends Frame implements ActionListener {
    Label instructions;
    Button showSymbolButton;
    Label symbolDisplay;
    String[] symbols;

    public MindReaderApp() {
        // Initialize symbols
        symbols = new String[]{"@", "#", "$", "%", "&", "*", "+", "-", "/", "~", "!", "^", "?", "<", ">", "|", ":", ";"};

   
        setLayout(new BorderLayout());

    
        instructions = new Label("<html>Think of any two-digit number. Now reverse it and find the difference of them.<br>Now find the number you got and remember the symbol from the panel below.<br>Don't tell me, I'll read your mind!<br>Hit the below button when you are ready to see the magic!</html>");
        instructions.setAlignment(Label.CENTER);
        add(instructions, BorderLayout.NORTH);

        // Symbol panel
        Panel symbolPanel = new Panel();
        symbolPanel.setLayout(new GridLayout(10, 10));
        for (int i = 0; i < 100; i++) {
            Label symbolLabel = new Label((i < 10 ? " " : "") + i + ": " + symbols[i % symbols.length]);
            symbolLabel.setAlignment(Label.CENTER);
            symbolPanel.add(symbolLabel);
        }
        add(symbolPanel, BorderLayout.CENTER);

 
        showSymbolButton = new Button("Show Symbol");
        showSymbolButton.addActionListener(this);
        add(showSymbolButton, BorderLayout.SOUTH);

      
        symbolDisplay = new Label("");
        symbolDisplay.setAlignment(Label.CENTER);
        symbolDisplay.setFont(new Font("Serif", Font.BOLD, 24));
        add(symbolDisplay, BorderLayout.SOUTH);

      
        setTitle("Mind Reader App");
        setSize(600, 800);
        setVisible(true);

        
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    public void actionPerformed(ActionEvent ae) {
        // Display the symbol for the result of the mind-reading trick
        symbolDisplay.setText("The symbol is: " + symbols[9]);
    }

    public static void main(String[] args) {
        new MindReaderApp();
    }
}
