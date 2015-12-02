package application.comparator;

import application.model.Child;
import application.model.dtos.mobile.response.parent.PositionForParentMDTOResponse;

import java.util.Comparator;

public class ChildComparator implements Comparator<Child> {
    @Override
    public int compare(Child o1, Child o2) {
        return o1.getChildId().compareTo(o2.getChildId());
    }
}