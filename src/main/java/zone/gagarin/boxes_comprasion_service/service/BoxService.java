package zone.gagarin.boxes_comprasion_service.service;

import zone.gagarin.boxes_comprasion_service.dto.Box;

public interface BoxService {

  String compareBoxes(Box firstBox, Box secondBox);

  boolean isValidBoxSize(Box box);

  Double[] creatingAnArrayOfBoxSizes(Box box);

  Double[] sortingBoxSizes(Double[] arrayOfBoxSizes);

}
