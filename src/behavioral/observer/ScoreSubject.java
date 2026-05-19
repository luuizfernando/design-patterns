package behavioral.observer;

import java.util.Observer;

/**
 * Role: Subject (Publisher)
 *
 * Maintains a list of observers interested in score updates.
 * Notifies all registered observers when the score changes.
 */
public interface ScoreSubject {

    void registerObserver(ScoreObserver observer);
    void removeObserver(ScoreObserver observer);
    void notifyObservers();

}