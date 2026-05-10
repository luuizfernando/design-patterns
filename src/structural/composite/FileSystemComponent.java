package structural.composite;

/**
 * Component role in Composite pattern

 * Common interface for both leaves (File) and composites (Folder),
 * letting clients treat them uniformly.
 */
public interface FileSystemComponent {

    String getName();
    long getSize();

    // TODO: print method
    void print(String indent);

}