package sg.edu.np.mad.madpractical;

public class User {
    public String name;
    public String description;
    public int id;
    public boolean followed;

    public User() {};

    public User(String n, String d, int i, boolean f) {
        this.name = n;
        this.description = d;
        this.id = i;
        this.followed = f;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public boolean isFollowed() {
        return followed;
    }

    public void changeFollowStatus() {
        if (isFollowed()) {
            followed = false;
        }
        else {
            followed = true;
        }
    }
}
