package item;

import java.awt.Point;

public interface PlaceItemOn {
    
    public abstract Point itemPlaceLocation();

    public abstract void tryAcquireItem(MobileItem item);
}
