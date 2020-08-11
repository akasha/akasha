package org.realityforge.webtack.model.tools.mdn_scanner;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.realityforge.webtack.model.tools.mdn_scanner.config2.EntryIndex;

public interface MdnScannerListener
{
  /**
   * Callback invoked when a scan has been queued.
   *
   * @param kind     the kind of documentation to expect.
   * @param typeName the name of the type.
   * @param name     the member name or null id kind is Type.
   */
  void queueScan( @Nonnull DocKind kind, @Nonnull String typeName, @Nullable String name );

  /**
   * Callback invoked before a fetch is attempted for entry.
   *
   * @param entryIndex the entry.
   * @param url        the url to fetch from.
   */
  void preEntryFetch( @Nonnull EntryIndex entryIndex, @Nonnull String url );

  /**
   * Callback invoked when entry no longer present on website and thus will be deleted from local cache.
   *
   * @param entryIndex the entry.
   */
  void entryDeleted( @Nonnull EntryIndex entryIndex );

  /**
   * Callback invoked after a fetch has retrieved content but before content is processed for extraction.
   *
   * @param entryIndex the entry.
   * @param url        the url fetched from.
   */
  void postEntryFetch( @Nonnull EntryIndex entryIndex, @Nonnull String url );

  /**
   * The entry has been updated and saved to local store.
   *
   * @param entryIndex the entry index.
   * @param entry      the updated entry.
   */
  void entryUpdated( @Nonnull EntryIndex entryIndex, @Nonnull DocEntry entry );

  /**
   * The entry has not changed after fetch.
   *
   * @param entryIndex the entry index.
   * @param entry      the updated entry.
   */
  void entryUnmodified( @Nonnull EntryIndex entryIndex, @Nonnull DocEntry entry );
}
