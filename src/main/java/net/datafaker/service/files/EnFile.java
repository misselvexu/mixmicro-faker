package net.datafaker.service.files;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EnFile {
    public static final String YML = ".yml";
    private final String file;
    private final String path;

    private EnFile(String file) {
        this(file, file.endsWith(YML) ? file.substring(0, file.length() - YML.length()) : file);
    }

    private EnFile(String file, String path) {
        this.file = file;
        this.path = path;
    }

    public String getFile() {
        return file;
    }

    public String getPath() {
        return path;
    }

    private static final List<EnFile> FILES = Stream.of(
        "address.yml",
        "ancient.yml",
        "animal.yml",
        "app.yml",
        "appliance.yml",
        "aqua_teen_hunger_force.yml",
        "artist.yml",
        "australia.yml",
        "aviation.yml",
        "aws.yml",
        "babylon5.yml",
        "back_to_the_future.yml",
        "barcode.yml",
        "bank.yml",
        "basketball.yml",
        "beer.yml",
        "bojack_horseman.yml",
        "book.yml",
        "bossa_nova.yml",
        "breaking_bad.yml",
        "brooklyn_nine_nine.yml",
        "buffy.yml",
        "business.yml",
//            "cannabis.yml",
        "chuck_norris.yml",
        "code.yml",
//            "coffee.yml",
        "coin.yml",
        "color.yml",
        "commerce.yml",
//            "community.yml",
        "company.yml",
//        "compass.yml",
//            "construction.yml",
//            "cosmere.yml",
        "country.yml",
        "crypto_coin.yml",
//            "culture_series.yml",
        "currency.yml",
//            "dc_comics.yml",
        "demographic.yml",
        "dessert.yml",
        "device.yml",
        "disease.yml",
        "domain.yml",
//            "dota.yml",
        "dr_who.yml",
        "dragon_ball.yml",
        "dumb_and_dumber.yml",
        "dune.yml",
        "educator.yml",
        "elder_scrolls.yml",
        "electrical_components.yml",
        "esport.yml",
        "englandfootball.yml",
//            "fallout.yml",
//            "family_guy.yml",
//            "famous_last_words.yml",
        "file.yml",
        "finance.yml",
        "food.yml",
//            "football.yml",
        "formula1.yml",
//            "fresh_prince_of_bel_air.yml",
        "friends.yml",
        "funny_name.yml",
        "game_of_thrones.yml",
//            "game.yml",
        "gender.yml",
//            "ghostbusters.yml",
        "grateful_dead.yml",
//            "greek_philosophers.yml",
        "hacker.yml",
        "half_life.yml",
        "harry_potter.yml",
        "hearthstone.yml",
        "heroes.yml",
        "heroes_of_the_storm.yml",
        "hey_arnold.yml",
        "hipster.yml",
        "hitchhikers_guide_to_the_galaxy.yml",
        "hobbit.yml",
        "hobby.yml",
//            "house.yml",
        "how_i_met_your_mother.yml",
        "id_number.yml",
//            "industry_segments.yml",
        "internet.yml",
//            "invoice.yml",
        "job.yml",
        "kpop.yml",
        "lebowski.yml",
        "lord_of_the_rings.yml",
        "lorem.yml",
//            "lovecraft.yml",
//            "markdown.yml",
        "marketing.yml",
        "matz.yml",
//            "measurement.yml",
        "medical.yml",
        "michael_scott.yml",
        "military.yml",
        "minecraft.yml",
        "most_interesting_man_in_the_world.yml",
        "mood.yml",
        "movie.yml",
        "mountain.yml",
        "mountaineering.yml",
        "music.yml",
//            "myst.yml",
        "name.yml",
        "nation.yml",
        "nato_phonetic_alphabet.yml",
//            "new_girl.yml",
//            "one_piece.yml",
//            "opera.yml",
        "nigeria.yml",
        "overwatch.yml",
        "OscarMovie.yml",
//            "parks_and_rec.yml",
//            "phish.yml",
        "phone_number.yml",
        "photography.yml",
        "pokemon.yml",
        "princess_bride.yml",
        "programming_language.yml",
        "relationship.yml",
        "restaurant.yml",
        "rick_and_morty.yml",
        "robin.yml",
        "rock_band.yml",
        "rupaul.yml",
        "science.yml",
        "seinfeld.yml",
        "shakespeare.yml",
//            "silicon_valley.yml",
//            "simpsons.yml",
//            "singular_siegler.yml",
        "sip.yml",
        "size.yml",
        "slack_emoji.yml",
//            "sonic_the_hedgehog.yml",
//            "source.yml",
//            "south_park.yml",
        "space.yml",
        "starcraft.yml",
        "star_trek.yml",
        "star_wars.yml",
//            "stargate.yml",
        "stock.yml",
//            "stranger_thing.yml",
//            "stripe.yml",
        "subscription.yml",
//            "super_smash_bros.yml",
        "superhero.yml",
//            "sword_art_online.yml",
        "team.yml",
//            "the_expanse.yml",
        "the_it_crowd.yml",
//            "the_thick_of_it.yml",
        "tron.yml",
        "twitter.yml",
        "twin_peaks.yml",
//            "umphreys_mcgee.yml",
        "university.yml",
//            "v_for_vendetta.yml",
        "vehicle.yml",
        "volleyball.yml",
//            "venture_bros.yml",
//            "verbs.yml",
        "weather.yml",
        "witcher.yml",
        "kaamelott.yml",
        "touhou.yml",
//        "world_cup.yml",
//            "world_of_warcraft.yml",
        "yoda.yml",
        "zelda.yml").map(EnFile::new).collect(Collectors.toList());

    // files where the search path can't be derived from the filename
    private static final List<EnFile> FILES_WITH_A_DIFFERENT_PATH = Arrays.asList(
        new EnFile("animal.yml", "creature"),
        new EnFile("cat.yml", "creature"),
        new EnFile("dog.yml", "creature"),
        new EnFile("horse.yml", "creature"),
        new EnFile("league_of_legends.yml", "games"),
        new EnFile("overwatch.yml", "games"),
//            new EnFile("dota.yml", "games"),
        new EnFile("pokemon.yml", "games"),
        new EnFile("super_mario.yml", "games"),
        new EnFile("witcher.yml", "games"),
        new EnFile("zelda.yml", "games"),
        new EnFile("elder_scrolls.yml", "games"),
        new EnFile("phone_number.yml", "cell_phone"), // load phone number again with a different path
        new EnFile("resident_evil.yml", "games"),
        new EnFile("hearthstone.yml", "games"));
    private static final List<EnFile> ALL_FILES;

    static {
        ALL_FILES = new ArrayList<>(FILES);
        ALL_FILES.addAll(FILES_WITH_A_DIFFERENT_PATH);
    }

    public static List<EnFile> getFiles() {
        return ALL_FILES;
    }
}
