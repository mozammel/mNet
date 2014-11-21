package org.jugbd.mnet.domain.enums;

/**
 * @author Bazlur Rahman Rokon
 * @since 10/1/14.
 */
public enum District {
    BARISAL("Barisal", "BRS", 0),
    BARGUNA("Barguna", "BRG", 1),
    BHOLA("Bhola", "BHO", 1),
    JHALAKHATI("Jhalakhati", "JHA", 1),
    PATUAKHALI("Patuakhali", "PAT", 1),
    PIROJPUR("Pirojpur", "PIR", 1),
    BANDARBAN("Bandarban", "BAN", 1),
    BRAHMANBARIA("Brahmanbaria", "BBA", 1),
    CHANDPUR("Chandpur", "CHA", 1),
    CHITTAGONG("Chittagong", "CHI", 0),
    COMILLA("Comilla", "COM", 1),
    COXS_BAZAR("Cox's Bazar", "COX", 1),
    FENI("Feni", "FEN", 1),
    KHAGRACHARI("Khagrachari", "KHA", 1),
    LAKSHMĪPUR("Lakshmipur", "LAK", 1),
    NOAKHALI("Noakhali", "NOA", 1),
    RANGAMATI("Rangamati", "RGM", 1),
    DHAKA("Dhaka", "DHA", 0),
    FARĪDPUR("Faridpur", "FAR", 1),
    GAZIPUR("Gazipur", "GAZ", 1),
    GOPALGANJ("Gopalganj", "GOP", 1),
    JAMALPUR("Jamalpur", "JAM", 1),
    KISHORGANJ("Kishorganj", "KIS", 1),
    MADARĪPUR("Madaripur", "MAD", 1),
    MANIKGANJ("Manikganj", "MAN", 1),
    MUNSHIGANJ("Munshiganj", "MUN", 1),
    MYMENSINGH("Mymensingh", "MYM", 1),
    NARAYANGANJ("Narayanganj", "NYG", 1),
    NARSINGDI("Narsingdi", "NSD", 1),
    NETRAKONA("Netrakona", "NET", 1),
    RAJBARI("Rajbari", "RJB", 1),
    SHARIATPUR("Shariatpur", "SHA", 1),
    SHERPUR("Sherpur", "SHE", 1),
    TANGAIL("Tangail", "TAN", 1),
    BAGERHAT("Bagerhat", "BAG", 1),
    CHUADANGA("Chuadanga", "CHU", 1),
    JESSORE("Jessore", "JES", 1),
    JHENIDA("Jhenida", "JHE", 1),
    KHULNA("Khulna", "KHU", 0),
    KUSHTIA("Kushtia", "KUS", 1),
    MAGURA("Magura", "MAG", 1),
    MEHERPUR("Meherpur", "MEH", 1),
    NARAIL("Narail", "NRA", 1),
    SATKHIRA("Satkhira", "SAT", 1),
    RAJSHAHI("Rajshahi", "RSD", 0),
    BOGRA("Bogra", "BOG", 1),
    JAIPUR_HAT("Jaipur Hat", "JAI", 1),
    NAOGAON("Naogaon", "NAO", 1),
    NATOR("Nator", "NAT", 1),
    NAWABGANJ_CHAPAI("Nawabganj (Chapai N.)", "NAW", 1),
    PABNA("Pabna", "PAB", 1),
    SIRAJGANJ("Sirajganj", "SIR", 1),
    DINAJPUR("Dinajpur", "DIN", 1),
    GAIBANDA("Gaibanda", "GAI", 1),
    KURĪGRAM("Kurigram", "KUR", 1),
    LALMONIR_HAT("Lalmonir Hat", "LAL", 1),
    NILPHAMARI("Nilphamari", "NIL", 1),
    PANCHAGARH("Panchagarh", "PAN", 1),
    RANGPUR("Rangpur", "RGP", 0),
    THAKURGAON("Thakurgaon", "THA", 1),
    SYLHET("Sylhet", "SYL", 0),
    HABIGANJ("Habiganj", "HAB", 1),
    MAULVI_BAZAR("Maulvi Bazar", "MAU", 1),
    SUNAMGANJ("Sunamganj", "SUN", 1);

    String name;
    String shortCode;
    int id;

    District(String name, String shortCode, int id) {
        this.name = name;
        this.shortCode = shortCode;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getShortCode() {
        return shortCode;
    }

    public int getId() {
        return id;
    }
}
