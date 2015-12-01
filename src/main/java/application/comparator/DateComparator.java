package application.comparator;

import application.model.dtos.mobile.response.parent.PositionForParentMDTOResponse;

import java.util.Comparator;

public class DateComparator implements Comparator<PositionForParentMDTOResponse> {
    @Override
    public int compare(PositionForParentMDTOResponse o1, PositionForParentMDTOResponse o2) {
        return o1.getCreationDate().compareTo(o2.getCreationDate());
    }
}