
package kata6.control;

import kata6.model.Block;

/**
 *
 * @author FernandoSanfielReyes
 * @version 1.0 2020/12/09 09:32 GMT
 *
 */

public class DownCommand implements Command{
    
    private final Block block;

    public DownCommand(Block block) {
        this.block = block;
    }

    @Override
    public void execute() {
        block.down();
    }

}
