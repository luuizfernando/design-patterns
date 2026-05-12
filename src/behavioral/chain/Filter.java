package behavioral.chain;

/**
 * Defines the contract  for all filters in the chain
 *
 * Each filter performs a task and optionally delegates
 * to the next filter in the filter chain
 */
public interface Filter {

    void setNext(Filter next);
    void apply(Request request);

}