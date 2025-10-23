package com.Project.Basic;

import java.util.*;

public class WordChecker {
    private static HashSet<String>set=new HashSet<>(Arrays.asList(
            "Artificial Intelligence",
            "Natural Language Processing",
            "Computer Language",
            "Intelligence Processing",
            "Language Processing",
            "the", "be", "to", "of", "and", "a", "in", "that", "have", "I",
            "it", "for", "not", "on", "with", "he", "as", "you", "do", "at",
            "this", "but", "his", "by", "from", "they", "we", "say", "her", "she",
            "or", "an", "will", "my", "one", "all", "would", "there", "their", "what",
            "so", "up", "out", "if", "about", "who", "get", "which", "go", "me",
            "when", "make", "can", "like", "time", "no", "just", "him", "know", "take",
            "people", "into", "year", "your", "good", "some", "could", "them", "see", "other",
            "than", "then", "now", "look", "only", "come", "its", "over", "think", "also",
            "back", "after", "use", "two", "how", "our", "work", "first", "well", "way",
            "even", "new", "want", "because", "any", "these", "give", "day", "most", "us",
            "is", "are", "was", "were", "been", "has", "did", "had", "does", "doing",
            "made", "done", "said", "told", "went", "come", "came", "saw", "got", "found",
            "need", "feel", "try", "leave", "call", "keep", "let", "put", "help", "show",
            "start", "talk", "turn", "move", "play", "run", "read", "write", "listen", "watch",
            "love", "like", "hate", "believe", "remember", "forget", "understand", "learn", "teach", "study",
            "build", "create", "grow", "change", "begin", "end", "open", "close", "stay", "live",
            "die", "sleep", "eat", "drink", "walk", "sit", "stand", "drive", "ride", "fly",
            "buy", "sell", "pay", "cost", "save", "spend", "work", "rest", "win", "lose",
            "stop", "wait", "meet", "talk", "hear", "think", "know", "understand", "hope", "wish",
            "dream", "plan", "decide", "choose", "show", "explain", "ask", "answer", "tell", "speak",
            "see", "look", "watch", "feel", "touch", "smell", "taste", "hear", "notice", "realize",
            "carry", "hold", "break", "cut", "hit", "throw", "catch", "push", "pull", "lift",
            "drive", "ride", "walk", "run", "jump", "swim", "fly", "climb", "fall", "stand",
            "sit", "sleep", "wake", "dream", "work", "rest", "play", "study", "learn", "teach",
            "help", "thank", "forgive", "send", "receive", "give", "take", "borrow", "lend", "use",
            "find", "lose", "remember", "forget", "understand", "believe", "hope", "wish", "try", "need", "above", "across", "action", "activity", "actually", "add", "address", "affect", "afraid", "after",
            "again", "against", "age", "ago", "agree", "air", "airport", "alive", "allow", "almost",
            "alone", "along", "already", "although", "always", "amazing", "amount", "analysis", "animal", "answer",
            "anyone", "anything", "anywhere", "appear", "apply", "area", "arm", "around", "arrive", "art",
            "article", "artist", "ask", "asleep", "assignment", "attack", "attempt", "attention", "audience", "author",
            "available", "average", "avoid", "away", "baby", "back", "bad", "bag", "ball", "bank",
            "bar", "base", "basic", "battle", "beautiful", "became", "become", "beginning", "behavior", "behind",
            "below", "benefit", "best", "better", "between", "beyond", "big", "bird", "bit", "black",
            "blue", "board", "boat", "body", "book", "born", "both", "bought", "box", "boy",
            "bring", "brother", "build", "building", "business", "busy", "buy", "camera", "capital", "car",
            "care", "career", "carry", "case", "catch", "cause", "center", "century", "certain", "chair",
            "chance", "change", "charge", "check", "child", "choice", "choose", "church", "city", "class",
            "clear", "climb", "clock", "close", "clothes", "club", "coach", "cold", "color", "come",
            "common", "company", "compare", "complete", "computer", "condition", "consider", "continue", "control", "cook",
            "cool", "copy", "corner", "correct", "cost", "could", "country", "course", "cover", "create",
            "credit", "culture", "current", "customer", "cut", "dark", "data", "daughter", "day", "deal",
            "death", "decide", "decision", "deep", "degree", "deliver", "department", "depend", "describe", "design",
            "detail", "develop", "development", "different", "difficult", "direction", "director", "discover", "discuss", "discussion",
            "disease", "distance", "doctor", "dog", "door", "down", "draw", "dream", "drive", "drop",
            "during", "each", "early", "earth", "east", "easy", "eat", "education", "effect", "effort",
            "eight", "either", "element", "else", "employee", "energy", "enjoy", "enough", "enter", "environment",
            "equal", "especially", "establish", "evening", "event", "ever", "every", "everyone", "everything", "evidence",
            "example", "except", "experience", "explain", "express", "eye", "face", "fact", "fail", "fall",
            "family", "famous", "far", "farm", "fast", "father", "fear", "feel", "feeling", "few",
            "field", "fight", "figure", "fill", "film", "final", "finally", "find", "fine", "finish",
            "fire", "firm", "first", "fish", "five", "floor", "follow", "food", "foot", "for",
            "force", "foreign", "forest", "forget", "form", "former", "forward", "free", "friend", "from",
            "front", "full", "function", "future", "game", "garden", "gas", "general", "girl", "give",
            "glass", "goal", "good", "government", "great", "green", "ground", "group", "grow", "growth",
            "guess", "hair", "half", "hand", "happen", "happy", "hard", "have", "head", "health",
            "hear", "heart", "heat", "heavy", "help", "high", "history", "hold", "home", "hope",
            "horse", "hospital", "hot", "hotel", "hour", "house", "however", "huge", "human", "hundred",
            "idea", "identify", "image", "imagine", "impact", "important", "improve", "include", "increase", "indeed",
            "industry", "information", "inside", "instead", "interest", "international", "interview", "into", "introduce", "involve",
            "issue", "item", "job", "join", "journey", "judge", "jump", "keep", "key", "kid",
            "kill", "kind", "kitchen", "knowledge", "land", "language", "large", "last", "late", "later",
            "laugh", "law", "lead", "leader", "learn", "least", "leave", "left", "leg", "less",
            "letter", "level", "library", "life", "light", "like", "line", "list", "listen", "little",
            "live", "local", "long", "look", "lose", "lot", "love", "low", "machine", "main",
            "major", "make", "man", "manage", "management", "many", "market", "marry", "material", "matter",
            "maybe", "mean", "measure", "meet", "member", "memory", "mention", "message", "method", "middle",
            "might", "million", "mind", "minute", "miss", "moment", "money", "month", "more", "morning",
            "most", "mother", "mountain", "move", "movie", "music", "must", "name", "nation", "natural",
            "nature", "near", "necessary", "need", "network", "never", "news", "newspaper", "next", "night",
            "none", "north", "note", "notice", "number", "object", "offer", "office", "often", "once",
            "only", "open", "operation", "opinion", "opportunity", "option", "order", "organization", "other", "outside",
            "over", "own", "page", "pain", "paper", "parent", "part", "partner", "party", "pass",
            "past", "patient", "pattern", "peace", "people", "perform", "period", "person", "phone", "place",
            "plan", "plant", "play", "player", "point", "police", "policy", "politics", "poor", "popular",
            "population", "position", "possible", "power", "practice", "prepare", "present", "pressure", "price", "process",
            "product", "program", "project", "property", "protect", "prove", "provide", "public", "purpose", "push",
            "quality", "question", "quick", "quiet", "quite", "radio", "raise", "range", "rate", "reach",
            "real", "reality", "realize", "reason", "receive", "recent", "record", "red", "reduce", "region",
            "relation", "relationship", "remember", "report", "require", "research", "resource", "respond", "result", "return",
            "rich", "right", "risk", "road", "rock", "role", "room", "rule", "run", "safe",
            "same", "save", "school", "science", "season", "seat", "second", "section", "security", "see",
            "seem", "sell", "send", "sense", "series", "service", "set", "seven", "several", "share",
            "short", "should", "show", "side", "sign", "similar", "simple", "since", "single", "sister",
            "skill", "small", "smile", "society", "some", "someone", "something", "sometimes", "son", "soon",
            "sort", "sound", "south", "space", "speak", "special", "specific", "speech", "spend", "sport",
            "spring", "staff", "stand", "standard", "start", "state", "station", "stay", "step", "still",
            "stop", "story", "street", "strong", "student", "study", "style", "subject", "success", "such",
            "sudden", "suffer", "suggest", "summer", "support", "sure", "system", "table", "take", "talk",
            "task", "teacher", "team", "technology", "television", "tell", "ten", "term", "test", "text",
            "than", "thank", "that", "their", "them", "themselves", "then", "theory", "thing", "think",
            "third", "this", "those", "though", "thought", "three", "through", "time", "together", "tonight",
            "too", "top", "total", "toward", "town", "trade", "training", "travel", "treat", "tree",
            "trial", "trip", "true", "trust", "try", "turn", "type", "under", "understand", "unit",
            "until", "upon", "use", "usually", "value", "various", "very", "video", "view", "visit",
            "voice", "wait", "walk", "wall", "want", "war", "watch", "water", "way", "wear",
            "week", "weight", "well", "west", "what", "when", "where", "whether", "which", "while",
            "white", "whole", "whose", "why", "wide", "wife", "will", "win", "wind", "window",
            "wish", "within", "without", "woman", "wonder", "word", "work", "world", "worry", "write",
            "writer", "wrong", "year", "yes", "yet", "young", "able", "about", "above", "accept", "according", "account", "across", "act", "action", "activity", "actually",
            "add", "address", "administration", "admit", "adult", "affect", "after", "again", "against", "age",
            "agency", "agent", "ago", "agree", "ahead", "air", "all", "allow", "almost", "alone", "along",
            "already", "also", "although", "always", "among", "amount", "analysis", "and", "animal", "another",
            "answer", "any", "anyone", "anything", "appear", "apply", "area", "argue", "arm", "around",
            "arrive", "art", "article", "artist", "as", "ask", "assume", "at", "attack", "attention",
            "attend", "authority", "available", "avoid", "away", "baby", "back", "bad", "bag", "ball",
            "bank", "bar", "base", "be", "beat", "beautiful", "because", "become", "bed", "before",
            "begin", "behavior", "behind", "believe", "benefit", "best", "better", "between", "beyond", "big",
            "bill", "billion", "bit", "black", "blood", "blue", "board", "body", "book", "born",
            "both", "box", "boy", "break", "bring", "brother", "budget", "build", "building", "business",
            "but", "buy", "by", "call", "camera", "campaign", "can", "cancer", "candidate", "capital",
            "car", "card", "care", "career", "carry", "case", "catch", "cause", "cell", "center",
            "central", "century", "certain", "chair", "challenge", "chance", "change", "character", "charge", "check",
            "child", "choice", "choose", "church", "citizen", "city", "civil", "claim", "class", "clear",
            "clearly", "close", "coach", "cold", "collection", "college", "color", "come", "commercial", "common",
            "community", "company", "compare", "computer", "concern", "condition", "conference", "consider", "consumer", "contain",
            "continue", "control", "cost", "could", "country", "couple", "course", "court", "cover", "create",
            "crime", "cultural", "culture", "cup", "current", "customer", "cut", "dark", "data", "daughter",
            "day", "dead", "deal", "death", "debate", "decade", "decide", "decision", "deep", "defense",
            "degree", "deliver", "demand", "democratic", "describe", "design", "detail", "determine", "develop", "development",
            "die", "difference", "different", "difficult", "dinner", "direction", "director", "discover", "discuss", "discussion",
            "disease", "do", "doctor", "dog", "door", "down", "draw", "dream", "drive", "drop",
            "drug", "during", "each", "early", "east", "easy", "eat", "economic", "economy", "edge",
            "education", "effect", "effort", "eight", "either", "election", "else", "employee", "end", "energy",
            "enjoy", "enough", "enter", "entire", "environment", "especially", "establish", "even", "evening", "event",
            "ever", "every", "everybody", "everyone", "everything", "evidence", "exactly", "example", "executive", "exist",
            "expect", "experience", "expert", "explain", "eye", "face", "fact", "factor", "fail", "fall",
            "family", "far", "fast", "father", "fear", "federal", "feel", "feeling", "few", "field",
            "fight", "figure", "fill", "film", "final", "finally", "financial", "find", "fine", "finish",
            "fire", "firm", "first", "fish", "five", "floor", "fly", "focus", "follow", "food",
            "foot", "for", "force", "foreign", "forget", "form", "former", "forward", "four", "free",
            "friend", "from", "front", "full", "fund", "future", "game", "garden", "gas", "general",
            "generation", "get", "girl", "give", "glass", "go", "goal", "good", "government", "great",
            "green", "ground", "group", "grow", "growth", "guess", "gun", "guy", "hair", "half",
            "hand", "hang", "happen", "happy", "hard", "have", "he", "head", "health", "hear",
            "heart", "heat", "heavy", "help", "her", "here", "herself", "high", "him", "himself",
            "his", "history", "hit", "hold", "home", "hope", "hospital", "hot", "hotel", "hour",
            "house", "how", "however", "huge", "human", "hundred", "husband", "I", "idea", "identify",
            "if", "image", "imagine", "impact", "important", "improve", "in", "include", "including", "increase",
            "indeed", "indicate", "individual", "industry", "information", "inside", "instead", "institution", "interest", "interesting",
            "international", "interview", "into", "investment", "involve", "issue", "it", "item", "its", "itself",
            "job", "join", "just", "keep", "key", "kid", "kill", "kind", "kitchen", "know",
            "knowledge", "land", "language", "large", "last", "late", "later", "laugh", "law", "lawyer",
            "lay", "lead", "leader", "learn", "least", "leave", "left", "leg", "legal", "less",
            "let", "letter", "level", "lie", "life", "light", "like", "likely", "line", "list",
            "listen", "little", "live", "local", "long", "look", "lose", "loss", "lot", "love",
            "low", "machine", "magazine", "main", "maintain", "major", "make", "man", "manage", "management",
            "manager", "many", "market", "marriage", "material", "matter", "may", "maybe", "me", "mean",
            "measure", "media", "medical", "meet", "meeting", "member", "memory", "mention", "message", "method",
            "middle", "might", "military", "million", "mind", "minute", "miss", "mission", "model", "modern",
            "moment", "money", "month", "more", "morning", "most", "mother", "move", "movement", "movie",
            "much", "music", "must", "my", "myself", "name", "nation", "national", "natural", "nature",
            "near", "nearly", "necessary", "need", "network", "never", "new", "news", "next", "nice",
            "night", "no", "none", "nor", "north", "not", "note", "nothing", "notice", "now",
            "number", "occur", "of", "off", "offer", "office", "officer", "official", "often", "oh",
            "oil", "ok", "old", "on", "once", "one", "only", "onto", "open", "operation",
            "opportunity", "option", "or", "order", "organization", "other", "others", "our", "out", "outside",
            "over", "own", "owner", "page", "pain", "painting", "paper", "parent", "part", "participant",
            "particular", "partner", "party", "pass", "past", "patient", "pattern", "pay", "peace", "people",
            "per", "performance", "perhaps", "period", "person", "personal", "phone", "physical", "pick", "picture",
            "piece", "place", "plan", "plant", "play", "player", "PM", "point", "police", "policy",
            "political", "politics", "poor", "popular", "population", "position", "positive", "possible", "power", "practice",
            "prepare", "present", "president", "pressure", "pretty", "prevent", "price", "private", "probably", "problem",
            "process", "produce", "product", "production", "professional", "program", "project", "property", "protect", "prove",
            "provide", "public", "purpose", "push", "put", "quality", "question", "quickly", "quite", "race",
            "radio", "raise", "range", "rate", "rather", "reach", "read", "ready", "real", "reality",
            "realize", "really", "reason", "receive", "recent", "recognize", "record", "red", "reduce", "reflect",
            "region", "relationship", "remain", "remember", "report", "represent", "require", "research", "resource", "respond",
            "result", "return", "rich", "right", "rise", "risk", "road", "rock", "role", "room",
            "rule", "run", "safe", "same", "save", "say", "scene", "school", "science", "scientist",
            "score", "sea", "season", "seat", "second", "section", "security", "see", "seek", "seem",
            "sell", "send", "sense", "series", "serious", "serve", "service", "set", "seven", "several",
            "shake", "share", "she", "short", "should", "show", "side", "sign", "simple", "since",
            "sing", "single", "sister", "sit", "site", "situation", "six", "size", "skill", "small",
            "smile", "so", "social", "society", "some", "somebody", "someone", "something", "sometimes", "son",
            "song", "soon", "sort", "sound", "source", "south", "space", "speak", "special", "specific",
            "speech", "spend", "sport", "spring", "staff", "stage", "stand", "standard", "star", "start",
            "state", "statement", "station", "stay", "step", "still", "stock", "stop", "store", "story",
            "strategy", "street", "strong", "student", "study", "stuff", "style", "subject", "success", "successful",
            "such", "suddenly", "suffer", "suggest", "summer", "support", "sure", "surface", "system", "table",
            "take", "talk", "task", "tax", "teach", "teacher", "team", "technology", "television", "tell",
            "ten", "term", "test", "than", "thank", "that", "the", "their", "them", "themselves",
            "then", "theory", "there", "these", "they", "thing", "think", "third", "this", "those",
            "though", "thought", "thousand", "three", "through", "throw", "thus", "time", "to", "today",
            "together", "tonight", "too", "top", "total", "toward", "town", "trade", "traditional", "training",
            "travel", "treat", "treatment", "tree", "trial", "trip", "trouble", "true", "truth", "try",
            "turn", "TV", "two", "type", "under", "understand", "unit", "until", "up", "upon",
            "us", "use", "usually", "value", "various", "very", "victim", "view", "visit", "voice",
            "vote", "wait", "walk", "wall", "want", "war", "watch", "water", "way", "we",
            "wear", "week", "weight", "well", "west", "what", "whatever", "when", "where", "whether",
            "which", "while", "white", "who", "whole", "whom", "whose", "why", "wide", "wife",
            "will", "win", "wind", "window", "wish", "with", "within", "without", "woman", "wonder",
            "word", "work", "worker", "world", "worry", "would", "write", "writer", "wrong", "year",
            "yes", "yet", "you", "young", "your", "yourself"
    ));
    private static List<String> dbms = new ArrayList<>(set);

    public static void main(String[] args) {
        WordChecker wc = new WordChecker();

        List<String> input = Arrays.asList("Lang", "Art");

        System.out.println(dbms);
//        System.out.println("Suggestions: " + wc.getSuggestions(input));
    }



    public List<String> getSuggestions(List<String> keywords) {
        Set<String> suggestions = new LinkedHashSet<>();

        for (String phrase : dbms) {
            String lowerPhrase = phrase.toLowerCase();
            boolean match = true;
            for (String key : keywords) {
                if (!lowerPhrase.contains(key.toLowerCase())) {
                    match = false;
                    break;
                }
            }

            if (match)
                suggestions.add(phrase);
        }


        if (suggestions.isEmpty()) {
            for (String phrase : dbms) {
                for (String key : keywords) {
                    if (phrase.toLowerCase().startsWith(key.toLowerCase())
                            || phrase.toLowerCase().contains(key.toLowerCase())) {
                        suggestions.add(phrase);
                    }
                }
            }
        }

        return new ArrayList<>(suggestions);
    }
}
