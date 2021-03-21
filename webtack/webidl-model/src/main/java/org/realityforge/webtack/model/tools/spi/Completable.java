package org.realityforge.webtack.model.tools.spi;

import javax.annotation.Nonnull;

/**
 * Interface that a stage can implement so that it can be invoked on completion.
 * This can be invoked to cleanup resource and or perform validation. It is most often
 * use for this second function which allows a stage to verify that it performed the expected
 * action.
 */
public interface Completable
{
  /**
   * Method invoked when stage has completed.
   */
  void onComplete();

  /**
   * Invoke {@link #onComplete()} on the parameter if the object implements {@link Completable}.
   *
   * @param object the object.
   */
  static void complete( @Nonnull final Object object )
  {
    if ( object instanceof Completable )
    {
      ( (Completable) object ).onComplete();
    }
  }
}
