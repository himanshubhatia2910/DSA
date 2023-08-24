class Solution {
  public List<String> fullJustify(String[] words, int maxWidth) {
         List<String> result = new ArrayList<>();
        List<String> line = new ArrayList<>();
        int lineLength = 0;

        for (String word : words) {
            if (lineLength + line.size() + word.length() > maxWidth) {
                if (line.size() == 1) {
                    result.add(line.get(0) + " ".repeat(maxWidth - lineLength));
                } else {
                    int extraSpaces = maxWidth - lineLength;
                    int spaceSlots = line.size() - 1;
                    int spacePerSlot = extraSpaces / spaceSlots;
                    int extraSpaceCount = extraSpaces % spaceSlots;
                    
                    StringBuilder formattedLine = new StringBuilder();
                    for (int i = 0; i < line.size() - 1; i++) {
                        formattedLine.append(line.get(i));
                        formattedLine.append(" ".repeat(spacePerSlot));
                        if (i < extraSpaceCount) {
                            formattedLine.append(" ");
                        }
                    }
                    formattedLine.append(line.get(line.size() - 1)); // Last word without extra space
                    result.add(formattedLine.toString());
                }
                
                line.clear();
                lineLength = 0;
            }

            line.add(word);
            lineLength += word.length();
        }

        // Left-justify the last line
        result.add(String.join(" ", line) + " ".repeat(maxWidth - lineLength - line.size() + 1));

        return result;
    }
}