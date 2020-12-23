package kata6.app;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import kata6.control.*;
import kata6.model.Block;
import kata6.view.BlockDisplay;

/**
 *
 * @author FernandoSanfielReyes
 * @version 1.0 2020/12/09 08:43 GMT
 *
 */

public class Kata6 extends JFrame{
    
    private final Block block;
    private BlockDisplay blockDisplay;
    private final Map<String,Command> commands;

    public static void main(String[] args) {
        new Kata6().execute();
    }

    public Kata6() {
        this.block = new Block();
        this.setTitle("Block shifter");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(700, 762);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.getContentPane().add(blockPanel());
        this.add(toolbar(), BorderLayout.SOUTH);
        this.commands = createCommands();
    }
    
    private void execute() {
        this.setVisible(true);
    }

    private JPanel blockPanel() {
        BlockPanel panel = new BlockPanel();
        this.blockDisplay = panel;
        panel.display(block);
        this.block.register(panel);
        return panel;
    }
    
    private Map<String, Command> createCommands(){
        Map<String,Command> commands = new HashMap<>();
        commands.put("U", new UpCommand(block));
        commands.put("D", new DownCommand(block));
        commands.put("L", new LeftCommand(block));
        commands.put("R", new RightCommand(block));
        return commands;
    }
    
    private JMenuBar toolbar() {
        JMenuBar result = new JMenuBar();
        result.setLayout(new FlowLayout(FlowLayout.CENTER));
        result.add(button("D"));
        result.add(button("L"));
        result.add(button("R"));
        result.add(button("U"));
        return result;
    }
    
    private JButton button(String command) {
        JButton button = new JButton(command);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                commands.get(command).execute();
            }
        });
        return button;
    }
}
