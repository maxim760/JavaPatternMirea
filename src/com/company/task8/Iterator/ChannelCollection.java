package src.com.company.task8.Iterator;

import java.util.ArrayList;
import java.util.List;

public class ChannelCollection {
  private List<RadioChannel> channelsList;
  public ChannelCollection() {
    channelsList = new ArrayList<>();
  }

  public void addChannel(RadioChannel c) {
    this.channelsList.add(c);
  }

  public void removeChannel(RadioChannel c) {
    this.channelsList.remove(c);
  }

  public List getChannels() {
    return channelsList;
  }
}
