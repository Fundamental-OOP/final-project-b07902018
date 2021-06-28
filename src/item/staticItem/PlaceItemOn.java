package item.staticItem;

import java.awt.Point;

import item.mobileItem.MobileItem;

public interface PlaceItemOn {
    
    public abstract Point itemPlaceLocation();

    public abstract void tryAcquireItem(MobileItem item);

    public abstract boolean hasSpace();
}
