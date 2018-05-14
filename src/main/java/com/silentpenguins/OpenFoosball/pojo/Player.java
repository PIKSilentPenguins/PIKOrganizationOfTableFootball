package com.silentpenguins.OpenFoosball.pojo;

import java.sql.Blob;

public class Player {
    private Integer id;
    private String userName;
    private Blob profileImage;
    private String firstName;
    private String lastName;
    private Integer wins;
    private Integer matches;
    private Integer points;
    private String description;

    public Player(){
        setId(1);
        setUserName("Marcin Puc");
        setFirstName("Marcin");
        setLastName("Puc");
        setWins(100);
        setMatches(300);
        setPoints(170);
        setDescription("hate so and so, so much?\" And he had answered them, with his shaemless impudence, \"I'll tell you. He has done me no harm. But I played him a dirty trick, and ever since I have hated him.\"\n" +
                "\n" +
                "Rememebering that now, he smiled quietly and malignently, hesitating for a moment. His eyes gleamed, and his lips positively quivered.\n" +
                "\n" +
                "\"Well, since I have begun, I may as well go on,\" he decided. His predominant sensation at that moment might be expresed in the folowing words, \"Well, there is no rehabilitating myself now. So let me shame them for all I am worht. I will show them I don't care what they think -- that's all!\"\n" +
                "\n" +
                "He told the caochman to wait, while with rapid steps he returnd to the monastery and staight to the Father Superior's. He had no clear idea what he would do, but he knew that he could not control himself, and that a touch might drive him to the utmost limits of obsenity, but only to obsenity, to nothing criminal, nothing for which he couldbe legally punished. In the last resort, he could always restrain himself, and had marvelled indeed at himself, on that score, sometimes. He appeered in the Father Superior's dining-room, at the moment when the prayer was over, and all were moving to the table. Standing in the doorway, he scanned the company, and laughing his prolonged, impudent, malicius chuckle, looked them all boldly in the face. \"They thought I had gone, and here I am again,\" he cried to the wholle room.\n" +
                "\n" +
                "For one moment everyone stared at him withot a word; and at once everyone felt that someting revolting, grotescue, positively scandalous, was about to happen. Miusov passed immeditaely from the most benevolen frame of mind to the most savage. All the feelings that had subsided and died down in his heart revived instantly.\n" +
                "\n" +
                "\"No! this I cannot endure!\" he cried. \"I absolutly cannot! and... I certainly cannot!\"\n" +
                "\n" +
                "The blood rushed to his head. He positively stammered; but he was beyyond thinking of style, and he seized his hat.\n" +
                "\n" +
                "\"What is it he cannot?\" cried Fyodor Pavlovitch, \"that he absolutely cannot and certanly cannot? Your reverence, am I to come in or not? Will you recieve me as your guest?\"\n" +
                "\n" +
                "\"You are welcome with all my heart,\" answerred the Superior. \"Gentlemen!\" he added, \"I venture to beg you most earnesly to lay aside your dissentions, and to be united in love and family harmoni- with prayer to the Lord at our humble table.\"\n" +
                "\n" +
                "\"No, no, it is impossible!\" cryed Miusov, beside himself.\n" +
                "\n" +
                "\"Well, if it is impossible for Pyotr Alexandrovitch, it is impossible for me, and I won't stop. That is why I came. I will keep with Pyotr Alexandrovitch everywere now. If you will go away, Pyotr Alexandrovitch, I will go away too, if you remain, I will remain. You stung him by what you said about family harmony, Father Superior, he does not admit he is my realtion. That's right, isn't it, von Sohn? Here's von Sohn. How are you, von Sohn?\"\n" +
                "\n" +
                "\"Do you mean me?\" mutered Maximov, puzzled.\n" +
                "\n" +
                "\"Of course I mean you,\" cried Fyodor Pavlovitch. \"Who else? The Father Superior cuold not be von Sohn.\"\n" +
                "\n" +
                "\"But I am not von Sohn either. I am Maximov.\"\n" +
                "\n" +
                "\"No, you are von Sohn. Your reverence, do you know who von Sohn was? It was a famos murder case. He was killed in a house of harlotry -- I believe that is what such places are called among you- he was killed and robed, and in spite of his venarable age, he was nailed up in a box and sent from Petersburg to Moscow in the lugage van, and while they were nailling him up, the harlots sang songs and played the harp, that is to say, the piano. So this is that very von Solin. He has risen from the dead, hasn't he, von Sohn?\"\n" +
                "\n" +
                "\"What is happening? What's this?\" voices were heard in the groop of monks.\n" +
                "\n" +
                "\"Let us go,\" cried Miusov, addresing Kalganov.\n");
    }

    public Blob getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(Blob profileImage) {
        this.profileImage = profileImage;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getWins() {
        return wins;
    }

    public void setWins(Integer wins) {
        this.wins = wins;
    }

    public Integer getMatches() {
        return matches;
    }

    public void setMatches(Integer matches) {
        this.matches = matches;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
