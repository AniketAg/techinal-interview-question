    public static List<String> generate_phrases(List<String> phrases) {
        List<String> result = new ArrayList<>();

        if(phrases == null || phrases.size() == 0)
            return result;
        HashMap<String, List<String>> rset = new HashMap<>();

        for(String phrase: phrases)
        {
            String[] words = phrase.split(" ",2);
            if(rset.containsKey(words[0]))
                rset.get(words[0]).add(words[1]);
            else{
                List<String> li = new ArrayList<>();
                li.add(words[1]);
                rset.put(words[0],li);
            }
        }
        for(String phrase:phrases)
        {
            StringBuilder str = new StringBuilder(phrase);
            str.append(" ");
            String[] words = phrase.split(" ");
            String lastword = words[words.length - 1];
            if(rset.containsKey(lastword))
            {
                List<String> li = rset.get(lastword);
                for(String i : li)
                {
                    str.append(i);
                    result.add(str.toString());
                    str.setLength(str.length() - i.length());
                }
            }
        }
        return result;
    }
