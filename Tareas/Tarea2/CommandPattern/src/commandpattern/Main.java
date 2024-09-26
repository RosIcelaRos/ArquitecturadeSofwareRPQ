import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

// Interfaz Command
interface Command {
    void execute();
    void undo();
}

// Clase Task (Reciever)
class Task {
    private String description;
    private boolean completed;

    public Task(String description) {
        this.description = description;
        this.completed = false;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        return (completed ? "[X] " : "[ ] ") + description;
    }
}

// Clase TaskManager (Reciever)
class TaskManager {
    private List<Task> tasks;

    public TaskManager() {
        tasks = new ArrayList<>();
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void removeTask(Task task) {
        tasks.remove(task);
    }

    public List<Task> getTasks() {
        return tasks;
    }
}

// Comando para añadir tarea (Comando Concreto)
class AddTaskCommand implements Command {
    private TaskManager taskManager;
    private Task task;

    public AddTaskCommand(TaskManager taskManager, Task task) {
        this.taskManager = taskManager;
        this.task = task;
    }

    @Override
    public void execute() {
        taskManager.addTask(task);
    }

    @Override
    public void undo() {
        taskManager.removeTask(task);
    }
}

// Comando para completar tarea (Comando Concreto)
class CompleteTaskCommand implements Command {
    private Task task;
    private boolean previousState;

    public CompleteTaskCommand(Task task) {
        this.task = task;
    }

    @Override
    public void execute() {
        previousState = task.isCompleted();
        task.setCompleted(true);
    }

    @Override
    public void undo() {
        task.setCompleted(previousState);
    }
}

// Clase TaskManagerApp (Interfaz Gráfica) (Invoker)
class TaskManagerApp extends JFrame {
    private TaskManager taskManager;
    private DefaultListModel<Task> listModel;
    private JList<Task> taskList;
    private JTextField taskInput;
    private JButton addButton;
    private JButton completeButton;
    private JButton undoButton;
    private List<Command> commandHistory;

    public TaskManagerApp() {
        taskManager = new TaskManager();
        listModel = new DefaultListModel<>();
        commandHistory = new ArrayList<>();

        setTitle("Gestor de Tareas");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        taskList = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(taskList);
        add(scrollPane, BorderLayout.CENTER);

        JPanel inputPanel = new JPanel();
        taskInput = new JTextField(20);
        addButton = new JButton("Añadir");
        inputPanel.add(taskInput);
        inputPanel.add(addButton);
        add(inputPanel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        completeButton = new JButton("Completar");
        undoButton = new JButton("Deshacer");
        buttonPanel.add(completeButton);
        buttonPanel.add(undoButton);
        add(buttonPanel, BorderLayout.SOUTH);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String description = taskInput.getText();
                if (!description.isEmpty()) {
                    Task newTask = new Task(description);
                    Command command = new AddTaskCommand(taskManager, newTask);
                    executeCommand(command);
                    taskInput.setText("");
                    updateTaskList();
                }
            }
        });

        completeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Task selectedTask = taskList.getSelectedValue();
                if (selectedTask != null && !selectedTask.isCompleted()) {
                    Command command = new CompleteTaskCommand(selectedTask);
                    executeCommand(command);
                    updateTaskList();
                }
            }
        });

        undoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!commandHistory.isEmpty()) {
                    Command lastCommand = commandHistory.remove(commandHistory.size() - 1);
                    lastCommand.undo();
                    updateTaskList();
                }
            }
        });
    }

    private void executeCommand(Command command) {
        command.execute();
        commandHistory.add(command);
    }

    private void updateTaskList() {
        listModel.clear();
        for (Task task : taskManager.getTasks()) {
            listModel.addElement(task);
        }
    }
}

// Clase Main (punto de entrada)
public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TaskManagerApp().setVisible(true);
            }
        });
    }
}
