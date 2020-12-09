
package kata6.view;

import kata6.model.Block;

/**
 *
 * @author FernandoSanfielReyes
 * @version 1.0 2020/12/09 09:00 GMT
 *
 */

public interface BlockDisplay extends Block.Observer{
    Block block();
    void display(Block block);
}
