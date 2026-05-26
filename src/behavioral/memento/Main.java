package behavioral.memento;

/**
 * Role: Client
 *
 * Demonstrates usage of the Memento Pattern
 * for course catalog history
 */
public class Main {
    public static void main(String[] args) {

        // ---------------------
        // SETUP
        // ---------------------
        CatalogQueryState queryState = new CatalogQueryState();
        CatalogQueryHistory queryHistory = new CatalogQueryHistory();
        System.out.println("Initial state: ");
        System.out.println(queryState);

        // ---------------------
        // BUILD QUERY
        // ---------------------
        queryHistory.saveBeforeChange(queryState);
        queryState.setSearchText("spring boot");

        queryHistory.saveBeforeChange(queryState);
        queryState.addFilter("level", "beginner");

        queryHistory.saveBeforeChange(queryState);
        queryState.addFilter("topic", "security");

        queryHistory.saveBeforeChange(queryState);
        queryState.setSort("rating",  SortDirection.DESCENDING);

        System.out.println("\nAfter building query: ");
        System.out.println(queryState);

        // ---------------------
        // REMOVE A FILTER
        // ---------------------
        queryHistory.saveBeforeChange(queryState);
        queryState.removeFilter("topic", "security");
        System.out.println("\nAfter removing topic=security");
        System.out.println(queryState);

        // ---------------------
        // CLEAR ALL FILTERS
        // ---------------------
        queryHistory.saveBeforeChange(queryState);
        queryState.clearFilters();
        System.out.println("\nAfter cleaning filters");
        System.out.println(queryState);

        // ---------------------
        // UNDO CLEAR
        // ---------------------
        boolean undoWorked = queryHistory.undo(queryState);
        System.out.println("\nAfter UNDO (restores previous state)");
        System.out.println(queryState);
        System.out.println("Undo worked: " + undoWorked);

        // ---------------------
        // UNDO REMOVE
        // ---------------------
        queryHistory.undo(queryState);
        System.out.println("\nAfter UNDO (restores removed filters)");
        System.out.println(queryState);

        // ---------------------
        // CHANGE SORT
        // ---------------------
        queryHistory.saveBeforeChange(queryState);
        queryState.setSort("name", SortDirection.ASCENDING);

        System.out.println("\nAfter CHANGE SORT to ASCENDING");
        System.out.println(queryState);

        // ---------------------
        // UNDO SORT CHANGE
        // ---------------------
        queryHistory.undo(queryState);
        System.out.println("\nAfter UNDO (restore previous sort)");
        System.out.println(queryState);

        // ---------------------
        // REDO
        // ---------------------
        queryHistory.redo(queryState);
        System.out.println("\nAfter REDO");
        System.out.println(queryState);

        // ---------------------
        // REDO CLEARING RULE
        // ---------------------
        queryHistory.saveBeforeChange(queryState);
        queryState.addFilter("level", "advanced");

        System.out.println("\nAfter new change (redo history cleaned)");
        System.out.println(queryState);

        boolean redoWorked = queryHistory.redo(queryState);
        System.out.println("\nTry REDO after new changes (should be false): " + redoWorked);

    }
}
