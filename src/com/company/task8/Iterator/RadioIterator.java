package src.com.company.task8.Iterator;

import java.util.Iterator;
import java.util.List;

public class RadioIterator implements Iterator<RadioChannel> {
  private List<RadioChannel> channels;
  private RadioType type;
  private int position;
  public RadioIterator(List<RadioChannel> c, RadioType type) {
    this.channels = c;
    this.position = 0;
    this.type = type;
  }

  @Override
  public boolean hasNext() {
    while (position < channels.size()) {
      RadioChannel c = channels.get(position);
      if (c.getType().equals(type)) {
        return true;
      } else
        position++;
    }
    return false;
  }

  @Override
  public RadioChannel next() {
    RadioChannel c = channels.get(position);
    position++;
    return c;
  }

}
