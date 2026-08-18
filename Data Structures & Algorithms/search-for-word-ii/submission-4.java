class Solution {

    class TrieNode {
        private final TrieNode[] children;
        private boolean isWord;
        private int references;

        private TrieNode() {
            this.children = new TrieNode[26];
        }

        private boolean isWord() {
            return isWord;
        }

        private void addWord(final String word) {
            int index = 0;
            TrieNode curr = this;
            curr.references++;
            while (index < word.length()) {
                final char letter = word.charAt(index);
                final int letterIndex = letter - 'a';
                TrieNode next = curr.children[letterIndex];
                if (next == null) {
                    next = new TrieNode();
                    curr.children[letterIndex] = next;
                }
                curr = next;
                curr.references++;
                index++;
            }
            curr.isWord = true;
        }

        private void deleteWord(final String word) {
            // IMPORTANT: Delete only those words that already exist in the Trie
            int index = 0;
            TrieNode curr = this;
            curr.references--;
            while (index < word.length()) {
                final char letter = word.charAt(index);
                final int letterIndex = letter - 'a';
                curr = curr.children[letterIndex];
                curr.references--;
                index++;
            }
            curr.isWord = false;
        }

        private TrieNode search(final char letter) {
            if (this.references == 0) {
                return null;
            }

            final int letterIndex = letter - 'a';
            final TrieNode next = this.children[letterIndex];
            if (next == null || next.references == 0) {
                return null;
            }

            return next;
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        final List<String> solution = new LinkedList<>();
        if (board.length == 0 || board[0].length == 0 || words.length == 0) {
            return solution;
        }

        // Given words are already unique, so no need of a hash set
        final TrieNode root = new TrieNode();
        for (final String word : words) {
            root.addWord(word);
        }

        final StringBuilder buffer = new StringBuilder();
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                buffer.setLength(0);
                searchForWords(board, row, col, root, root, solution, buffer);
            }
        }

        return solution;
    }

    private void searchForWords(
        final char[][] board, final int row, final int col, final TrieNode root, final TrieNode node,
        final List<String> solution, final StringBuilder buffer) {
        if (row < 0 || row >= board.length
            || col < 0 || col >= board[row].length) {
            return;
        }

        final char cellVal = board[row][col];
        if (cellVal == '#') {
            return;
        }

        final TrieNode curr = node.search(cellVal);
        if (curr == null) {
            return;
        }

        // To act as visited cache
        board[row][col] = '#';
        buffer.append(cellVal);
        
        if (curr.isWord()) {
            final String wordSoFar = buffer.toString();
            solution.add(wordSoFar);
            root.deleteWord(wordSoFar);
        }
        
        searchForWords(board, row, col + 1, root, curr, solution, buffer);
        searchForWords(board, row, col - 1, root, curr, solution, buffer);
        searchForWords(board, row + 1, col, root, curr, solution, buffer);
        searchForWords(board, row - 1, col, root, curr, solution, buffer);

        // Restore the original value once exploring from this cell is done
        board[row][col] = cellVal;
        buffer.deleteCharAt(buffer.length() - 1);
    }
}
