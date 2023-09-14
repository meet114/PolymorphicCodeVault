package account;

/**
 * Enum representing the status of an account in the system.
 * <ul>
 *     <li><b>Normal</b>: Account is fully functional.</li>
 *     <li><b>Muted</b>: Can see posts but their own posts are hidden.</li>
 *     <li><b>Blocked</b>: Cannot log in.</li>
 * </ul>
 *
 * @author Meet Saspara
 * @version 1.1
 * @since 2025
 */
public enum AccountStatus {
    Normal, // Account is fully functional
    Muted, // Can see posts but their own posts are hidden
    Blocked, // Cannot log in
}
