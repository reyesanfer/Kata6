
package kata6.control;

import kata6.model.Block;

/**
 *
 * @author FernandoSanfielReyes
 * @version 1.0 2020/12/09 09:33 GMT
 *
 */

public class LeftCommand implements Command{
    
    private final Block block;

    public LeftCommand(Block block) {
        this.block = block;
    }

    @Override
    public void execute() {
        block.left();
    }

}
