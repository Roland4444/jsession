package abstractions;
import com.sun.jna.Callback;
import com.sun.jna.Library;
import com.sun.jna.Native;

public class TestCall {
    public interface CLibrary extends Library {
        public static final CLibrary INSTANCE = (CLibrary) Native.loadLibrary("l", CLibrary.class);

        public interface void__ extends Callback {
            void apply();
        };

        void__ inc_i() ;
        void__ get_i() ;
    }

    CLibrary.void__ inc(){
        return CLibrary.INSTANCE.inc_i();
    };

    CLibrary.void__ get(){
        return CLibrary.INSTANCE.get_i();
    };

    public static void main(String[] args) throws InterruptedException {
        var call = new TestCall();
        for (int i=0; i<10; i++){
            call.inc();
            call.get();
        }
    }
}
