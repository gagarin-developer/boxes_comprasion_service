package zone.gagarin.boxes_comprasion_service.service;

import java.util.Arrays;
import org.springframework.stereotype.Service;
import zone.gagarin.boxes_comprasion_service.dto.Box;

@Service
public class BoxServiceImplementation implements BoxService {

  @Override
  public String compareBoxes(Box firstBox, Box secondBox) {
    if (isValidBoxSize(firstBox) && isValidBoxSize(secondBox)) {
      Double[] firstBoxSizes = sortingBoxSizes(creatingAnArrayOfBoxSizes(firstBox));
      Double[] secondBoxSizes = sortingBoxSizes(creatingAnArrayOfBoxSizes(secondBox));
      if (Arrays.equals(firstBoxSizes, secondBoxSizes)) {
        return "Boxes are equal";
      } else if (firstBoxSizes[0] <= secondBoxSizes[0] && firstBoxSizes[1] <= secondBoxSizes[1]
          && firstBoxSizes[2] <= secondBoxSizes[2]) {
        return "The first box is smaller than the second one";
      } else if (firstBoxSizes[0] >= secondBoxSizes[0] && firstBoxSizes[1] >= secondBoxSizes[1]
          && firstBoxSizes[2] >= secondBoxSizes[2]) {
        return "The first box is larger than the second one";
      } else {
        return "Boxes are incomparable";
      }
    } else{
      return "Incorrect box sizes have been entered";
    }
  }

  public boolean isValidBoxSize(Box box) {
    return box.getLength() > 0 && box.getWeight() > 0 && box.getHeight() > 0;
  }

  public Double[] creatingAnArrayOfBoxSizes(Box box) {
    return new Double[]{box.getLength(), box.getWeight(), box.getHeight()};
  }

  public Double[] sortingBoxSizes(Double[] arrayOfBoxSizes) {
    Arrays.sort(arrayOfBoxSizes);
    return arrayOfBoxSizes;
  }
}
