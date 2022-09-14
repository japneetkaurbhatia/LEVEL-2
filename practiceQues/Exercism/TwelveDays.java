class TwelveDays {
    String verse(int verseNumber) {
        if (verseNumber == 1) {
            return "On the first day of Christmas my true love gave to me: a Partridge in a Pear Tree.\n";
        } else if (verseNumber == 2) {
            return "On the second day of Christmas my true love gave to me: two Turtle Doves, and a Partridge in a Pear Tree.\n";
        } else if (verseNumber == 3) {
            return "On the third day of Christmas my true love gave to me: three French Hens, two Turtle Doves, and a Partridge in a Pear Tree.\n";
        } else if (verseNumber == 4) {
            return "On the fourth day of Christmas my true love gave to me: four Calling Birds, three French Hens, two Turtle Doves, and a Partridge in a Pear Tree.\n";
        } else if (verseNumber == 5) {
            return "On the fifth day of Christmas my true love gave to me: five Gold Rings, four Calling Birds, three French Hens, two Turtle Doves, and a Partridge in a Pear Tree.\n";
        } else if (verseNumber == 6) {
            return "On the sixth day of Christmas my true love gave to me: six Geese-a-Laying, five Gold Rings, four Calling Birds, three French Hens, two Turtle Doves, and a Partridge in a Pear Tree.\n";
        } else if (verseNumber == 7) {
            return "On the seventh day of Christmas my true love gave to me: seven Swans-a-Swimming, six Geese-a-Laying, five Gold Rings, four Calling Birds, three French Hens, two Turtle Doves, and a Partridge in a Pear Tree.\n";
        } else if (verseNumber == 8) {
            return "On the eighth day of Christmas my true love gave to me: eight Maids-a-Milking, seven Swans-a-Swimming, six Geese-a-Laying, five Gold Rings, four Calling Birds, three French Hens, two Turtle Doves, and a Partridge in a Pear Tree.\n";
        } else if (verseNumber == 9) {
            return "On the ninth day of Christmas my true love gave to me: nine Ladies Dancing, eight Maids-a-Milking, seven Swans-a-Swimming, six Geese-a-Laying, five Gold Rings, four Calling Birds, three French Hens, two Turtle Doves, and a Partridge in a Pear Tree.\n";
        } else if (verseNumber == 10) {
            return "On the tenth day of Christmas my true love gave to me: ten Lords-a-Leaping, nine Ladies Dancing, eight Maids-a-Milking, seven Swans-a-Swimming, six Geese-a-Laying, five Gold Rings, four Calling Birds, three French Hens, two Turtle Doves, and a Partridge in a Pear Tree.\n";
        } else if (verseNumber == 11) {
            return "On the eleventh day of Christmas my true love gave to me: eleven Pipers Piping, ten Lords-a-Leaping, nine Ladies Dancing, eight Maids-a-Milking, seven Swans-a-Swimming, six Geese-a-Laying, five Gold Rings, four Calling Birds, three French Hens, two Turtle Doves, and a Partridge in a Pear Tree.\n";
        } else if (verseNumber == 12) {
            return "On the twelfth day of Christmas my true love gave to me: twelve Drummers Drumming, eleven Pipers Piping, ten Lords-a-Leaping, nine Ladies Dancing, eight Maids-a-Milking, seven Swans-a-Swimming, six Geese-a-Laying, five Gold Rings, four Calling Birds, three French Hens, two Turtle Doves, and a Partridge in a Pear Tree.\n";
        }
        return "";
    }
    
    String verses(int startVerse, int endVerse) {
        String returnString = "";
        for (int i = startVerse; i < endVerse; i++) {
            returnString += verse(i) + "\n";
        }
        returnString += verse(endVerse);
        return returnString;
    }
    
    String sing() {
        String returnString = "";
        for (int i = 1; i < 12; i++) {
            returnString += verse(i) + "\n";
        }
        returnString += verse(12);
        return returnString;
    }
}