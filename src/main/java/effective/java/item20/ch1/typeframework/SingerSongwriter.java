package effective.java.item20.ch1.typeframework;

/**
 * 여러 interface 를 상속받을수있기때문에
 * 굉장히 편하다.
 */
public interface SingerSongwriter extends Singer, Songwriter{

    AudioClip strum();
    void actSensitive();
}
