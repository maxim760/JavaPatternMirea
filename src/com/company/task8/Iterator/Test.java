package src.com.company.task8.Iterator;

public class Test {
  public static void main(String[] args) {
    ChannelCollection channels = new ChannelCollection();
    channels.addChannel(new RadioChannel(69.26, "Русская служба новостей", RadioType.STEREO));
    channels.addChannel(new RadioChannel(71.30, "Русское радио", RadioType.MONO));
    channels.addChannel(new RadioChannel(73.82, "Эхо Москвы", RadioType.MONO));
    channels.addChannel(new RadioChannel(88.30, "Ретро ФМ", RadioType.STEREO));
    channels.addChannel(new RadioChannel(106.20, "Европа Плюс", RadioType.STEREO));

    RadioIterator monoIterator = new RadioIterator(channels.getChannels(), RadioType.MONO);
    RadioIterator stereoIterator = new RadioIterator(channels.getChannels(), RadioType.STEREO);

    while (monoIterator.hasNext()) {
      System.out.println("MONO: " + monoIterator.next().toString());
    }

    while (stereoIterator.hasNext()) {
      System.out.println("STEREO: " + stereoIterator.next().toString());
    }


  }
}
