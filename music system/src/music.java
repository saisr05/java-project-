import java.util.Scanner;

public class music {
    public static void main(String[] args) {
        MusicPlayer mp;
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the musicplayer local or online");
        String musicPlayerType = sc.nextLine();
        //localfile
        if(musicPlayerType.equals("local")){

            LocalFileMusicPlayer localfile = new LocalFileMusicPlayer();
            mp = new LocalFileAdapter(localfile);
            String str = "hi" ;

            while(!str.equalsIgnoreCase("exit")){

                System.out.println(" TO play press p , to stop press s" + 
                "to increase volume press v and the level"+ " press exit to exit player" );
                str = sc.nextLine();
                if(str.equalsIgnoreCase("p")){
                  mp.play();
                }
                else if(str.equalsIgnoreCase("v")){
                    int level = sc.nextInt();
                  mp = new VolumeControlDecorator(mp);
                   /*VolumeControlDecorator class, which are not available in the MusicPlayer interface. */
                   ((VolumeControlDecorator)mp).setVolume(level);
                }
                else if(str.equalsIgnoreCase("s")){
                    mp.stop();
                }
            }

        }
        else if(musicPlayerType.equalsIgnoreCase("online")){
           OnlineStreamingMusicPlayer localfile = new OnlineStreamingMusicPlayer();
            mp = new OnlineStreamingAdapter(localfile);
            String str = "hi" ;

            while(!str.equalsIgnoreCase("exit")){

                System.out.println(" TO play press p , to stop press s" + 
                "to increase volume press v and the level " + " press exit to exit player" );
                str = sc.nextLine();
                if(str.equalsIgnoreCase("p")){
                  mp.play();
                }
                else if(str.equalsIgnoreCase("v")){
                    int level = sc.nextInt();
                   mp = new VolumeControlDecorator(mp);
                   /*VolumeControlDecorator class, which are not available in the MusicPlayer interface. */
                   ((VolumeControlDecorator)mp).setVolume(level);
                }
                else if(str.equalsIgnoreCase("s")){
                    mp.stop();
                }

            }
        }
        sc.close();
    }
}
//Target Interface
 interface MusicPlayer {
    void play();
    void stop();
}
//Adaptee
 class LocalFileMusicPlayer {
    public void playLocalFile() {
        System.out.println("Playing music from local file...");
    }

    public void stopLocalFile() {
        System.out.println("Stopping music from local file...");
    }
}
//Adapter 
 class LocalFileAdapter implements MusicPlayer {
    private LocalFileMusicPlayer localFileMusicPlayer;

    public LocalFileAdapter(LocalFileMusicPlayer localFileMusicPlayer) {
        this.localFileMusicPlayer = localFileMusicPlayer;
    }

    @Override
    public void play() {
        localFileMusicPlayer.playLocalFile();
    }

    @Override
    public void stop() {
        localFileMusicPlayer.stopLocalFile();
    }
}

//Adaptee
 class OnlineStreamingMusicPlayer {
    public void playOnlineStream() {
        System.out.println("Playing online streaming music...");
    }

    public void stopOnlineStream() {
        System.out.println("Stopping online streaming music...");
    }
}

//Adapter
 class OnlineStreamingAdapter implements MusicPlayer {
    private OnlineStreamingMusicPlayer onlineStreamingMusicPlayer;

    public OnlineStreamingAdapter(OnlineStreamingMusicPlayer onlineStreamingMusicPlayer) {
        this.onlineStreamingMusicPlayer = onlineStreamingMusicPlayer;
    }

    @Override
    public void play() {
        onlineStreamingMusicPlayer.playOnlineStream();
    }

    @Override
    public void stop() {
        onlineStreamingMusicPlayer.stopOnlineStream();
    }
}

//Decorator
 abstract class MusicPlayerDecorator implements MusicPlayer {
    protected MusicPlayer decoratedMusicPlayer;

    public MusicPlayerDecorator(MusicPlayer decoratedMusicPlayer) {
        this.decoratedMusicPlayer = decoratedMusicPlayer;
    }

    @Override
    public void play() {
        decoratedMusicPlayer.play();
    }

    @Override
    public void stop() {
        decoratedMusicPlayer.stop();
    }
}

//concrete decrator
 class VolumeControlDecorator extends MusicPlayerDecorator {
    public VolumeControlDecorator(MusicPlayer decoratedMusicPlayer) {
        super(decoratedMusicPlayer);
    }

    public void setVolume(int level) {
        System.out.println("Setting volume to " + level);
    }
}

