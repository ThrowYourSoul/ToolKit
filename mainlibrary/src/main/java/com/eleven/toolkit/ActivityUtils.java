package com.eleven.toolkit;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import java.util.List;

/**
 * <pre>
 *     author: Blankj
 *     blog  : http://blankj.com
 *     time  : 2016/09/23
 *     desc  : utils about activity
 * </pre>
 */
public final class ActivityUtils {

    private ActivityUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    /**
     * Return whether the activity exists.
     *
     * @param pkg The name of the package.
     * @param cls The name of the class.
     * @return {@code true}: yes<br>{@code false}: no
     */
    public static boolean isActivityExists( final String pkg,
                                            final String cls) {
        Intent intent = new Intent();
        intent.setClassName(pkg, cls);
        return !(ToolKit.getApp().getPackageManager().resolveActivity(intent, 0) == null ||
                intent.resolveActivity(ToolKit.getApp().getPackageManager()) == null ||
                ToolKit.getApp().getPackageManager().queryIntentActivities(intent, 0).size() == 0);
    }

    /**
     * Start the activity.
     *
     * @param clz The activity class.
     */
    public static void startActivity( final Class<? extends Activity> clz) {
        Context context = ToolKit.getTopActivityOrApp();
        startActivity(context, null, context.getPackageName(), clz.getName(), null);
    }

    /**
     * Start the activity.
     *
     * @param clz     The activity class.
     * @param options Additional options for how the Activity should be started.
     */
    public static void startActivity( final Class<? extends Activity> clz,
                                     final Bundle options) {
        Context context = ToolKit.getTopActivityOrApp();
        startActivity(context, null, context.getPackageName(), clz.getName(), options);
    }


    /**
     * Start the activity.
     *
     * @param activity The activity.
     * @param clz      The activity class.
     */
    public static void startActivity( final Activity activity,
                                      final Class<? extends Activity> clz) {
        startActivity(activity, null, activity.getPackageName(), clz.getName(), null);
    }

    /**
     * Start the activity.
     *
     * @param activity The activity.
     * @param clz      The activity class.
     * @param options  Additional options for how the Activity should be started.
     */
    public static void startActivity( final Activity activity,
                                      final Class<? extends Activity> clz,
                                     final Bundle options) {
        startActivity(activity, null, activity.getPackageName(), clz.getName(), options);
    }



    /**
     * Start the activity.
     *
     * @param extras The Bundle of extras to add to this intent.
     * @param clz    The activity class.
     */
    public static void startActivity( final Bundle extras,
                                      final Class<? extends Activity> clz) {
        Context context = ToolKit.getTopActivityOrApp();
        startActivity(context, extras, context.getPackageName(), clz.getName(), null);
    }

    /**
     * Start the activity.
     *
     * @param extras  The Bundle of extras to add to this intent.
     * @param clz     The activity class.
     * @param options Additional options for how the Activity should be started.
     */
    public static void startActivity( final Bundle extras,
                                      final Class<? extends Activity> clz,
                                      final Bundle options) {
        Context context = ToolKit.getTopActivityOrApp();
        startActivity(context, extras, context.getPackageName(), clz.getName(), options);
    }


    /**
     * Start the activity.
     *
     * @param extras   The Bundle of extras to add to this intent.
     * @param activity The activity.
     * @param clz      The activity class.
     */
    public static void startActivity( final Bundle extras,
                                      final Activity activity,
                                      final Class<? extends Activity> clz) {
        startActivity(activity, extras, activity.getPackageName(), clz.getName(), null);
    }

    /**
     * Start the activity.
     *
     * @param extras   The Bundle of extras to add to this intent.
     * @param activity The activity.
     * @param clz      The activity class.
     * @param options  Additional options for how the Activity should be started.
     */
    public static void startActivity( final Bundle extras,
                                      final Activity activity,
                                      final Class<? extends Activity> clz,
                                      final Bundle options) {
        startActivity(activity, extras, activity.getPackageName(), clz.getName(), options);
    }

    /**
     * Start the activity.
     *
     * @param pkg The name of the package.
     * @param cls The name of the class.
     */
    public static void startActivity( final String pkg,
                                      final String cls) {
        startActivity(ToolKit.getTopActivityOrApp(), null, pkg, cls, null);
    }

    /**
     * Start the activity.
     *
     * @param pkg     The name of the package.
     * @param cls     The name of the class.
     * @param options Additional options for how the Activity should be started.
     */
    public static void startActivity( final String pkg,
                                      final String cls,
                                     final Bundle options) {
        startActivity(ToolKit.getTopActivityOrApp(), null, pkg, cls, options);
    }


    /**
     * Start the activity.
     *
     * @param activity The activity.
     * @param pkg      The name of the package.
     * @param cls      The name of the class.
     */
    public static void startActivity( final Activity activity,
                                      final String pkg,
                                      final String cls) {
        startActivity(activity, null, pkg, cls, null);
    }

    /**
     * Start the activity.
     *
     * @param activity The activity.
     * @param pkg      The name of the package.
     * @param cls      The name of the class.
     * @param options  Additional options for how the Activity should be started.
     */
    public static void startActivity( final Activity activity,
                                      final String pkg,
                                      final String cls,
                                     final Bundle options) {
        startActivity(activity, null, pkg, cls, options);
    }

    /**
     * Start the activity.
     *
     * @param extras The Bundle of extras to add to this intent.
     * @param pkg    The name of the package.
     * @param cls    The name of the class.
     */
    public static void startActivity( final Bundle extras,
                                      final String pkg,
                                      final String cls) {
        startActivity(ToolKit.getTopActivityOrApp(), extras, pkg, cls, null);
    }

    /**
     * Start the activity.
     *
     * @param extras  The Bundle of extras to add to this intent.
     * @param pkg     The name of the package.
     * @param cls     The name of the class.
     * @param options Additional options for how the Activity should be started.
     */
    public static void startActivity( final Bundle extras,
                                      final String pkg,
                                      final String cls,
                                     final Bundle options) {
        startActivity(ToolKit.getTopActivityOrApp(), extras, pkg, cls, options);
    }


    /**
     * Start the activity.
     *
     * @param activity The activity.
     * @param extras   The Bundle of extras to add to this intent.
     * @param pkg      The name of the package.
     * @param cls      The name of the class.
     */
    public static void startActivity( final Bundle extras,
                                      final Activity activity,
                                      final String pkg,
                                      final String cls) {
        startActivity(activity, extras, pkg, cls, null);
    }

    /**
     * Start the activity.
     *
     * @param extras   The Bundle of extras to add to this intent.
     * @param activity The activity.
     * @param pkg      The name of the package.
     * @param cls      The name of the class.
     * @param options  Additional options for how the Activity should be started.
     */
    public static void startActivity( final Bundle extras,
                                      final Activity activity,
                                      final String pkg,
                                      final String cls,
                                     final Bundle options) {
        startActivity(activity, extras, pkg, cls, options);
    }




    /**
     * Start the activity.
     *
     * @param intent The description of the activity to start.
     */
    public static void startActivity( final Intent intent) {
        startActivity(intent, ToolKit.getTopActivityOrApp(), null);
    }

    /**
     * Start the activity.
     *
     * @param intent  The description of the activity to start.
     * @param options Additional options for how the Activity should be started.
     */
    public static void startActivity( final Intent intent,
                                      final Bundle options) {
        startActivity(intent, ToolKit.getTopActivityOrApp(), options);
    }

    /**
     * Start the activity.
     *
     * @param activity The activity.
     * @param intent   The description of the activity to start.
     */
    public static void startActivity( final Activity activity,
                                      final Intent intent) {
        startActivity(intent, activity, null);
    }

    /**
     * Start the activity.
     *
     * @param activity The activity.
     * @param intent   The description of the activity to start.
     * @param options  Additional options for how the Activity should be started.
     */
    public static void startActivity( final Activity activity,
                                      final Intent intent,
                                     final Bundle options) {
        startActivity(intent, activity, options);
    }


    /**
     * Start the activity.
     *
     * @param activity    The activity.
     * @param clz         The activity class.
     * @param requestCode if &gt;= 0, this code will be returned in
     *                    onActivityResult() when the activity exits.
     */
    public static void startActivityForResult( final Activity activity,
                                               final Class<? extends Activity> clz,
                                              final int requestCode) {
        startActivityForResult(activity, null, activity.getPackageName(), clz.getName(),
                requestCode, null);
    }

    /**
     * Start the activity.
     *
     * @param activity    The activity.
     * @param clz         The activity class.
     * @param requestCode if &gt;= 0, this code will be returned in
     *                    onActivityResult() when the activity exits.
     * @param options     Additional options for how the Activity should be started.
     */
    public static void startActivityForResult( final Activity activity,
                                               final Class<? extends Activity> clz,
                                              final int requestCode,
                                              final Bundle options) {
        startActivityForResult(activity, null, activity.getPackageName(), clz.getName(),
                requestCode, options);
    }


    /**
     * Start the activity.
     *
     * @param extras      The Bundle of extras to add to this intent.
     * @param activity    The activity.
     * @param clz         The activity class.
     * @param requestCode if &gt;= 0, this code will be returned in
     *                    onActivityResult() when the activity exits.
     */
    public static void startActivityForResult( final Bundle extras,
                                               final Activity activity,
                                               final Class<? extends Activity> clz,
                                              final int requestCode) {
        startActivityForResult(activity, extras, activity.getPackageName(), clz.getName(),
                requestCode, null);
    }

    /**
     * Start the activity.
     *
     * @param extras      The Bundle of extras to add to this intent.
     * @param activity    The activity.
     * @param clz         The activity class.
     * @param requestCode if &gt;= 0, this code will be returned in
     *                    onActivityResult() when the activity exits.
     * @param options     Additional options for how the Activity should be started.
     */
    public static void startActivityForResult( final Bundle extras,
                                               final Activity activity,
                                               final Class<? extends Activity> clz,
                                              final int requestCode,
                                               final Bundle options) {
        startActivityForResult(activity, extras, activity.getPackageName(), clz.getName(),
                requestCode, options);
    }

    /**
     * Start the activity for result.
     *
     * @param activity    The activity.
     * @param extras      The Bundle of extras to add to this intent.
     * @param pkg         The name of the package.
     * @param cls         The name of the class.
     * @param requestCode if &gt;= 0, this code will be returned in
     *                    onActivityResult() when the activity exits.
     */
    public static void startActivityForResult( final Bundle extras,
                                               final Activity activity,
                                               final String pkg,
                                               final String cls,
                                              final int requestCode) {
        startActivityForResult(activity, extras, pkg, cls, requestCode, null);
    }

    /**
     * Start the activity for result.
     *
     * @param extras      The Bundle of extras to add to this intent.
     * @param activity    The activity.
     * @param pkg         The name of the package.
     * @param cls         The name of the class.
     * @param requestCode if &gt;= 0, this code will be returned in
     *                    onActivityResult() when the activity exits.
     * @param options     Additional options for how the Activity should be started.
     */
    public static void startActivityForResult( final Bundle extras,
                                               final Activity activity,
                                               final String pkg,
                                               final String cls,
                                              final int requestCode,
                                              final Bundle options) {
        startActivityForResult(activity, extras, pkg, cls, requestCode, options);
    }

    /**
     * Start the activity for result.
     *
     * @param activity    The activity.
     * @param intent      The description of the activity to start.
     * @param requestCode if &gt;= 0, this code will be returned in
     *                    onActivityResult() when the activity exits.
     */
    public static void startActivityForResult( final Activity activity,
                                               final Intent intent,
                                              final int requestCode) {
        startActivityForResult(intent, activity, requestCode, null);
    }

    /**
     * Start the activity for result.
     *
     * @param activity    The activity.
     * @param intent      The description of the activity to start.
     * @param requestCode if &gt;= 0, this code will be returned in
     *                    onActivityResult() when the activity exits.
     * @param options     Additional options for how the Activity should be started.
     */
    public static void startActivityForResult( final Activity activity,
                                               final Intent intent,
                                              final int requestCode,
                                              final Bundle options) {
        startActivityForResult(intent, activity, requestCode, options);
    }


    /**
     * Start activities.
     *
     * @param intents The descriptions of the activities to start.
     */
    public static void startActivities( final Intent[] intents) {
        startActivities(intents, ToolKit.getTopActivityOrApp(), null);
    }

    /**
     * Start activities.
     *
     * @param intents The descriptions of the activities to start.
     * @param options Additional options for how the Activity should be started.
     */
    public static void startActivities( final Intent[] intents,
                                       final Bundle options) {
        startActivities(intents, ToolKit.getTopActivityOrApp(), options);
    }

    /**
     * Start activities.
     *
     * @param activity The activity.
     * @param intents  The descriptions of the activities to start.
     */
    public static void startActivities( final Activity activity,
                                        final Intent[] intents) {
        startActivities(intents, activity, null);
    }

    /**
     * Start activities.
     *
     * @param activity The activity.
     * @param intents  The descriptions of the activities to start.
     * @param options  Additional options for how the Activity should be started.
     */
    public static void startActivities( final Activity activity,
                                        final Intent[] intents,
                                       final Bundle options) {
        startActivities(intents, activity, options);
    }



    /**
     * Start home activity.
     */
    public static void startHomeActivity() {
        Intent homeIntent = new Intent(Intent.ACTION_MAIN);
        homeIntent.addCategory(Intent.CATEGORY_HOME);
        startActivity(homeIntent);
    }

    /**
     * Return the list of activity.
     *
     * @return the list of activity
     */
    public static List<Activity> getActivityList() {
        return ToolKit.getActivityList();
    }

    /**
     * Return the name of launcher activity.
     *
     * @return the name of launcher activity
     */
    public static String getLauncherActivity() {
        return getLauncherActivity(ToolKit.getApp().getPackageName());
    }

    /**
     * Return the name of launcher activity.
     *
     * @param pkg The name of the package.
     * @return the name of launcher activity
     */
    public static String getLauncherActivity( final String pkg) {
        Intent intent = new Intent(Intent.ACTION_MAIN, null);
        intent.addCategory(Intent.CATEGORY_LAUNCHER);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        PackageManager pm = ToolKit.getApp().getPackageManager();
        List<ResolveInfo> info = pm.queryIntentActivities(intent, 0);
        for (ResolveInfo aInfo : info) {
            if (aInfo.activityInfo.packageName.equals(pkg)) {
                return aInfo.activityInfo.name;
            }
        }
        return "no " + pkg;
    }

    /**
     * Return the top activity in activity's stack.
     *
     * @return the top activity in activity's stack
     */
    public static Activity getTopActivity() {
        return ToolKit.getActivityLifecycle().getTopActivity();
    }

    /**
     * Return whether the activity exists in activity's stack.
     *
     * @param activity The activity.
     * @return {@code true}: yes<br>{@code false}: no
     */
    public static boolean isActivityExistsInStack( final Activity activity) {
        List<Activity> activities = ToolKit.getActivityList();
        for (Activity aActivity : activities) {
            if (aActivity.equals(activity)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Return whether the activity exists in activity's stack.
     *
     * @param clz The activity class.
     * @return {@code true}: yes<br>{@code false}: no
     */
    public static boolean isActivityExistsInStack( final Class<? extends Activity> clz) {
        List<Activity> activities = ToolKit.getActivityList();
        for (Activity aActivity : activities) {
            if (aActivity.getClass().equals(clz)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Finish the activity.
     *
     * @param activity The activity.
     */
    public static void finishActivity( final Activity activity) {
        finishActivity(activity, false);
    }

    /**
     * Finish the activity.
     *
     * @param activity   The activity.
     * @param isLoadAnim True to use animation for the outgoing activity, false otherwise.
     */
    public static void finishActivity( final Activity activity, final boolean isLoadAnim) {
        activity.finish();
        if (!isLoadAnim) {
            activity.overridePendingTransition(0, 0);
        }
    }

    /**
     * Finish the activity.
     *
     * @param activity  The activity.
     * @param enterAnim A resource ID of the animation resource to use for the
     *                  incoming activity.
     * @param exitAnim  A resource ID of the animation resource to use for the
     *                  outgoing activity.
     */
    public static void finishActivity( final Activity activity,
                                       final int enterAnim,
                                       final int exitAnim) {
        activity.finish();
        activity.overridePendingTransition(enterAnim, exitAnim);
    }

    /**
     * Finish the activity.
     *
     * @param clz The activity class.
     */
    public static void finishActivity( final Class<? extends Activity> clz) {
        finishActivity(clz, false);
    }

    /**
     * Finish the activity.
     *
     * @param clz        The activity class.
     * @param isLoadAnim True to use animation for the outgoing activity, false otherwise.
     */
    public static void finishActivity( final Class<? extends Activity> clz,
                                      final boolean isLoadAnim) {
        List<Activity> activities = ToolKit.getActivityList();
        for (Activity activity : activities) {
            if (activity.getClass().equals(clz)) {
                activity.finish();
                if (!isLoadAnim) {
                    activity.overridePendingTransition(0, 0);
                }
            }
        }
    }

    /**
     * Finish the activity.
     *
     * @param clz       The activity class.
     * @param enterAnim A resource ID of the animation resource to use for the
     *                  incoming activity.
     * @param exitAnim  A resource ID of the animation resource to use for the
     *                  outgoing activity.
     */
    public static void finishActivity( final Class<? extends Activity> clz,
                                       final int enterAnim,
                                       final int exitAnim) {
        List<Activity> activities = ToolKit.getActivityList();
        for (Activity activity : activities) {
            if (activity.getClass().equals(clz)) {
                activity.finish();
                activity.overridePendingTransition(enterAnim, exitAnim);
            }
        }
    }

    /**
     * Finish to the activity.
     *
     * @param activity      The activity.
     * @param isIncludeSelf True to include the activity, false otherwise.
     */
    public static boolean finishToActivity( final Activity activity,
                                           final boolean isIncludeSelf) {
        return finishToActivity(activity, isIncludeSelf, false);
    }

    /**
     * Finish to the activity.
     *
     * @param activity      The activity.
     * @param isIncludeSelf True to include the activity, false otherwise.
     * @param isLoadAnim    True to use animation for the outgoing activity, false otherwise.
     */
    public static boolean finishToActivity( final Activity activity,
                                           final boolean isIncludeSelf,
                                           final boolean isLoadAnim) {
        List<Activity> activities = ToolKit.getActivityList();
        for (int i = activities.size() - 1; i >= 0; --i) {
            Activity aActivity = activities.get(i);
            if (aActivity.equals(activity)) {
                if (isIncludeSelf) {
                    finishActivity(aActivity, isLoadAnim);
                }
                return true;
            }
            finishActivity(aActivity, isLoadAnim);
        }
        return false;
    }

    /**
     * Finish to the activity.
     *
     * @param activity      The activity.
     * @param isIncludeSelf True to include the activity, false otherwise.
     * @param enterAnim     A resource ID of the animation resource to use for the
     *                      incoming activity.
     * @param exitAnim      A resource ID of the animation resource to use for the
     *                      outgoing activity.
     */
    public static boolean finishToActivity( final Activity activity,
                                           final boolean isIncludeSelf,
                                            final int enterAnim,
                                            final int exitAnim) {
        List<Activity> activities = ToolKit.getActivityList();
        for (int i = activities.size() - 1; i >= 0; --i) {
            Activity aActivity = activities.get(i);
            if (aActivity.equals(activity)) {
                if (isIncludeSelf) {
                    finishActivity(aActivity, enterAnim, exitAnim);
                }
                return true;
            }
            finishActivity(aActivity, enterAnim, exitAnim);
        }
        return false;
    }

    /**
     * Finish to the activity.
     *
     * @param clz           The activity class.
     * @param isIncludeSelf True to include the activity, false otherwise.
     */
    public static boolean finishToActivity( final Class<? extends Activity> clz,
                                           final boolean isIncludeSelf) {
        return finishToActivity(clz, isIncludeSelf, false);
    }

    /**
     * Finish to the activity.
     *
     * @param clz           The activity class.
     * @param isIncludeSelf True to include the activity, false otherwise.
     * @param isLoadAnim    True to use animation for the outgoing activity, false otherwise.
     */
    public static boolean finishToActivity( final Class<? extends Activity> clz,
                                           final boolean isIncludeSelf,
                                           final boolean isLoadAnim) {
        List<Activity> activities = ToolKit.getActivityList();
        for (int i = activities.size() - 1; i >= 0; --i) {
            Activity aActivity = activities.get(i);
            if (aActivity.getClass().equals(clz)) {
                if (isIncludeSelf) {
                    finishActivity(aActivity, isLoadAnim);
                }
                return true;
            }
            finishActivity(aActivity, isLoadAnim);
        }
        return false;
    }

    /**
     * Finish to the activity.
     *
     * @param clz           The activity class.
     * @param isIncludeSelf True to include the activity, false otherwise.
     * @param enterAnim     A resource ID of the animation resource to use for the
     *                      incoming activity.
     * @param exitAnim      A resource ID of the animation resource to use for the
     *                      outgoing activity.
     */
    public static boolean finishToActivity( final Class<? extends Activity> clz,
                                           final boolean isIncludeSelf,
                                            final int enterAnim,
                                            final int exitAnim) {
        List<Activity> activities = ToolKit.getActivityList();
        for (int i = activities.size() - 1; i >= 0; --i) {
            Activity aActivity = activities.get(i);
            if (aActivity.getClass().equals(clz)) {
                if (isIncludeSelf) {
                    finishActivity(aActivity, enterAnim, exitAnim);
                }
                return true;
            }
            finishActivity(aActivity, enterAnim, exitAnim);
        }
        return false;
    }

    /**
     * Finish the activities whose type not equals the activity class.
     *
     * @param clz The activity class.
     */
    public static void finishOtherActivities( final Class<? extends Activity> clz) {
        finishOtherActivities(clz, false);
    }


    /**
     * Finish the activities whose type not equals the activity class.
     *
     * @param clz        The activity class.
     * @param isLoadAnim True to use animation for the outgoing activity, false otherwise.
     */
    public static void finishOtherActivities( final Class<? extends Activity> clz,
                                             final boolean isLoadAnim) {
        List<Activity> activities = ToolKit.getActivityList();
        for (int i = activities.size() - 1; i >= 0; i--) {
            Activity activity = activities.get(i);
            if (!activity.getClass().equals(clz)) {
                finishActivity(activity, isLoadAnim);
            }
        }
    }

    /**
     * Finish the activities whose type not equals the activity class.
     *
     * @param clz       The activity class.
     * @param enterAnim A resource ID of the animation resource to use for the
     *                  incoming activity.
     * @param exitAnim  A resource ID of the animation resource to use for the
     *                  outgoing activity.
     */
    public static void finishOtherActivities( final Class<? extends Activity> clz,
                                              final int enterAnim,
                                              final int exitAnim) {
        List<Activity> activities = ToolKit.getActivityList();
        for (int i = activities.size() - 1; i >= 0; i--) {
            Activity activity = activities.get(i);
            if (!activity.getClass().equals(clz)) {
                finishActivity(activity, enterAnim, exitAnim);
            }
        }
    }

    /**
     * Finish all of activities.
     */
    public static void finishAllActivities() {
        finishAllActivities(false);
    }

    /**
     * Finish all of activities.
     *
     * @param isLoadAnim True to use animation for the outgoing activity, false otherwise.
     */
    public static void finishAllActivities(final boolean isLoadAnim) {
        List<Activity> activityList = ToolKit.getActivityList();
        for (int i = activityList.size() - 1; i >= 0; --i) {// remove from top
            Activity activity = activityList.get(i);
            // sActivityList remove the index activity at onActivityDestroyed
            activity.finish();
            if (!isLoadAnim) {
                activity.overridePendingTransition(0, 0);
            }
        }
    }

    /**
     * Finish all of activities.
     *
     * @param enterAnim A resource ID of the animation resource to use for the
     *                  incoming activity.
     * @param exitAnim  A resource ID of the animation resource to use for the
     *                  outgoing activity.
     */
    public static void finishAllActivities( final int enterAnim,
                                            final int exitAnim) {
        List<Activity> activityList = ToolKit.getActivityList();
        for (int i = activityList.size() - 1; i >= 0; --i) {// remove from top
            Activity activity = activityList.get(i);
            // sActivityList remove the index activity at onActivityDestroyed
            activity.finish();
            activity.overridePendingTransition(enterAnim, exitAnim);
        }
    }

    /**
     * Finish all of activities except the newest activity.
     */
    public static void finishAllActivitiesExceptNewest() {
        finishAllActivitiesExceptNewest(false);
    }

    /**
     * Finish all of activities except the newest activity.
     *
     * @param isLoadAnim True to use animation for the outgoing activity, false otherwise.
     */
    public static void finishAllActivitiesExceptNewest(final boolean isLoadAnim) {
        List<Activity> activities = ToolKit.getActivityList();
        for (int i = activities.size() - 2; i >= 0; i--) {
            finishActivity(activities.get(i), isLoadAnim);
        }
    }

    /**
     * Finish all of activities except the newest activity.
     *
     * @param enterAnim A resource ID of the animation resource to use for the
     *                  incoming activity.
     * @param exitAnim  A resource ID of the animation resource to use for the
     *                  outgoing activity.
     */
    public static void finishAllActivitiesExceptNewest( final int enterAnim,
                                                        final int exitAnim) {
        List<Activity> activities = ToolKit.getActivityList();
        for (int i = activities.size() - 2; i >= 0; i--) {
            finishActivity(activities.get(i), enterAnim, exitAnim);
        }
    }

    /**
     * Return the icon of activity.
     *
     * @param activity The activity.
     * @return the icon of activity
     */
    public static Drawable getActivityIcon( final Activity activity) {
        return getActivityIcon(activity.getComponentName());
    }

    /**
     * Return the icon of activity.
     *
     * @param clz The activity class.
     * @return the icon of activity
     */
    public static Drawable getActivityIcon( final Class<? extends Activity> clz) {
        return getActivityIcon(new ComponentName(ToolKit.getApp(), clz));
    }

    /**
     * Return the icon of activity.
     *
     * @param activityName The name of activity.
     * @return the icon of activity
     */
    public static Drawable getActivityIcon( final ComponentName activityName) {
        PackageManager pm = ToolKit.getApp().getPackageManager();
        try {
            return pm.getActivityIcon(activityName);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Return the logo of activity.
     *
     * @param activity The activity.
     * @return the logo of activity
     */
    public static Drawable getActivityLogo( final Activity activity) {
        return getActivityLogo(activity.getComponentName());
    }

    /**
     * Return the logo of activity.
     *
     * @param clz The activity class.
     * @return the logo of activity
     */
    public static Drawable getActivityLogo( final Class<? extends Activity> clz) {
        return getActivityLogo(new ComponentName(ToolKit.getApp(), clz));
    }

    /**
     * Return the logo of activity.
     *
     * @param activityName The name of activity.
     * @return the logo of activity
     */
    public static Drawable getActivityLogo( final ComponentName activityName) {
        PackageManager pm = ToolKit.getApp().getPackageManager();
        try {
            return pm.getActivityLogo(activityName);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static void startActivity(final Context context,
                                      final Bundle extras,
                                      final String pkg,
                                      final String cls,
                                      final Bundle options) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        if (extras != null) intent.putExtras(extras);
        intent.setComponent(new ComponentName(pkg, cls));
        startActivity(intent, context, options);
    }

    private static void startActivity(final Intent intent,
                                      final Context context,
                                      final Bundle options) {
        if (!(context instanceof Activity)) {
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        }
        if (options != null && Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            context.startActivity(intent, options);
        } else {
            context.startActivity(intent);
        }
    }

    private static void startActivityForResult(final Activity activity,
                                               final Bundle extras,
                                               final String pkg,
                                               final String cls,
                                               final int requestCode,
                                               final Bundle options) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        if (extras != null) intent.putExtras(extras);
        intent.setComponent(new ComponentName(pkg, cls));
        startActivityForResult(intent, activity, requestCode, options);
    }

    private static void startActivityForResult(final Intent intent,
                                               final Activity activity,
                                               final int requestCode,
                                               final Bundle options) {
        if (options != null && Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            activity.startActivityForResult(intent, requestCode, options);
        } else {
            activity.startActivityForResult(intent, requestCode);
        }
    }

    private static void startActivities(final Intent[] intents,
                                        final Context context,
                                        final Bundle options) {
        if (!(context instanceof Activity)) {
            for (Intent intent : intents) {
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            }
        }
        if (options != null && Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            context.startActivities(intents, options);
        } else {
            context.startActivities(intents);
        }
    }

}