import java.io.*;

/**
 * Created by WQS on 2017/7/28.
 * Mail: 1027738387@qq.com
 * Github: https://github.com/wannibar
 */
public class DecoratorTest {
    public static void main(String[] args) throws IOException {
        Room animalFlowerRoom = new WithAnimalRoom(new WithFlowerRoom(new BlankRoom()));
        animalFlowerRoom.showRoom();

        System.out.println("++++++++++++++++++++++");

        Room flowerAnimalRoom = new WithFlowerRoom(new WithAnimalRoom(new BlankRoom()));
        flowerAnimalRoom.showRoom();

        System.out.println("++++++++++++++++++++++");

        EcodeInputStream.test();
    }


    static class EcodeInputStream extends FilterInputStream {

        protected EcodeInputStream(InputStream in) {
            super(in);
        }

        @Override
        public int read() throws IOException {
            return super.read() + 1;
        }

        public static void test() throws IOException {
            byte[] buf = new byte[]{'a', 'b', 'c'};
            InputStream is = new EcodeInputStream(new ByteArrayInputStream(buf, 0, 3));
            int ch = -1;
            while ((ch = is.read()) != 0)
                System.out.println(ch);
        }
    }

    public interface Room {
        void showRoom();
    }

    static class BlankRoom implements Room {
        @Override
        public void showRoom() {
            System.out.println("空房子");
        }
    }

    // 类似FilterInputStream
    abstract static class RoomDecorator implements Room {
        private Room toBeDecoratedRoom;

        public RoomDecorator(Room toBeDecoratedRoom) {
            this.toBeDecoratedRoom = toBeDecoratedRoom;
        }

        @Override
        public void showRoom() {
            toBeDecoratedRoom.showRoom();
        }
    }

    // 类比BufferedInputStream
    static class WithFlowerRoom extends RoomDecorator {

        public WithFlowerRoom(Room tobeDecoratedRoom) {
            super(tobeDecoratedRoom);
        }

        @Override
        public void showRoom() {
            System.out.println("种上花...");
            super.showRoom();
        }
    }

    static class WithAnimalRoom extends RoomDecorator {

        public WithAnimalRoom(Room toBeDecoratedRoom) {
            super(toBeDecoratedRoom);
        }

        @Override
        public void showRoom() {
            System.out.println("有动物...");
            super.showRoom();
        }
    }

}
