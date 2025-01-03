#!/bin/bash

# Check if commit hash is provided as an argument
if [ -z "$1" ]; then
  echo "Usage: $0 <commit-hash>"
  exit 1
fi

# Commit to cherry-pick (from the command-line argument)
COMMIT_HASH="$1"

# List of branches
BRANCHES=(
  "sample-code/lesson-1-your-first-serenity-bdd-test-case"
  "sample-code/lesson-2-serenity-bdd-step-methods"
  "sample-code/lesson-3-steps-with-parameters"
  "sample-code/lesson-5-locating-elements"
  "sample-code/lesson-6-action-classes"
  "sample-code/lesson-8-page-objects"
  "sample-code/lesson-9-findby-annotation"
  "sample-code/lesson-10-page-objects-without-findbys"
  "sample-code/lesson-11-working-with-form-fields"
  "sample-code/lesson-12-working-with-checkboxes"
  "sample-code/lesson-13-dropdowns"
  "sample-code/lesson-14-contact-form"
  "sample-code/lesson-15-mouse-interactions"
  "sample-code/lesson-16-url-configuration"
  "sample-code/lesson-17-implicit-waits"
  "sample-code/lesson-18-explicit-waits"
  "sample-code/lesson-19-chrome-configuration"
  "sample-code/lesson-20-environments"
  "sample-code/todomvc-solution"
)

# Iterate over each branch
for BRANCH in "${BRANCHES[@]}"; do
  echo "Processing branch: $BRANCH"

  # Checkout the branch
  git checkout "$BRANCH"
  if [ $? -ne 0 ]; then
    echo "Failed to checkout branch: $BRANCH"
    continue
  fi

  # Cherry-pick the commit
  git cherry-pick "$COMMIT_HASH"
  if [ $? -ne 0 ]; then
    echo "Merge conflict detected on branch: $BRANCH"
    echo "Please resolve the conflict, commit the changes, and type 'continue' to proceed, or 'abort' to skip this branch."
    
    while true; do
      read -p "Type 'continue' to proceed or 'abort' to skip this branch: " RESPONSE
      case $RESPONSE in
        continue)
          echo "Continuing after resolving the conflict..."
          break
          ;;
        abort)
          echo "Aborting cherry-pick on branch: $BRANCH"
          git cherry-pick --abort
          continue 2
          ;;
        *)
          echo "Invalid input. Please type 'continue' or 'abort'."
          ;;
      esac
    done
  fi

  # Commit the changes if no conflict or resolved
  git commit --allow-empty -m "Cherry-pick commit $COMMIT_HASH to update branch $BRANCH"
  if [ $? -ne 0 ]; then
    echo "Failed to commit changes on branch: $BRANCH"
    continue
  fi

  # Push the changes to origin
  git push origin "$BRANCH"
  if [ $? -ne 0 ]; then
    echo "Failed to push branch: $BRANCH"
    continue
  fi

  echo "Successfully processed branch: $BRANCH"
done

echo "All branches processed."
