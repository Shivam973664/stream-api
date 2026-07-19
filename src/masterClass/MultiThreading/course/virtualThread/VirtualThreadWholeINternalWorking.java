package masterClass.MultiThreading.course.virtualThread;

public class VirtualThreadWholeINternalWorking {
/*
 * Here's a concise version of your notes with a few corrections for accuracy.

---

# Virtual Threads – Internal Working (Short Notes)

### 1. Coroutine Concept

* A **coroutine** is a task that can **pause** its execution and **resume later from the same point**.
* Unlike a normal method, it doesn't always start from the beginning after pausing.
* `yield()` is the operation that **suspends** the coroutine and returns control to the scheduler/caller.
* When resumed, execution continues from where it previously stopped.

### 2. Continuation (Java Virtual Threads)

* Java Virtual Threads are built on **Continuations** (an internal JDK mechanism that provides coroutine-like behavior).
* A continuation captures the current execution state so it can be resumed later.

### 3. What happens when a Virtual Thread blocks?

When a Virtual Thread performs a blocking operation (e.g., file I/O, HTTP call, database call):

1. The Virtual Thread is **unmounted** from its Platform Thread.
2. Its execution state (stack frames, local variables, program counter, etc.) is **saved on the heap**.
3. The Platform Thread is immediately free to execute another Virtual Thread.
4. Once the blocking operation completes, the scheduler **mounts** the Virtual Thread onto an available Platform Thread.
5. Execution resumes **exactly from where it was suspended**.

### 4. Why is this efficient?

* Platform Threads are **not blocked** waiting for I/O.
* Thousands or even millions of Virtual Threads can share a small pool of Platform Threads.
* This provides high scalability for I/O-bound applications.

### Easy Memory Trick

> **Run → Block → Save State (Heap) → Release Platform Thread → I/O Completes → Assign Platform Thread → Resume**

### Small Correction

* `yield()` is **not** what resumes a Virtual Thread after an I/O operation. `yield()` simply gives up execution voluntarily. For blocking I/O, the JDK scheduler automatically unmounts the Virtual Thread, saves its continuation, and later remounts it when the blocking operation completes.

 */
}
